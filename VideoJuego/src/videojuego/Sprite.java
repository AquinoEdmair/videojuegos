/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aquinoedmair
 */
public class Sprite {
    
    private int dx;
    private int x;
    private int y;
    private int auxy;
    private int auxx;
    private Image imagen;
    private Animacion animacion;
    private Sonido brincar;
    private boolean enmovimiento = false;
    private boolean findondo = false;
    
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        iniciaSprite();
    }
    
    private void iniciaSprite() {
        
        CargaImagen imagenPersonaje = new CargaImagen();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = imagenPersonaje.cargarImagen("mario.png");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        Personaje personaje = new Personaje(bufferedImage);
        
        ArrayList<BufferedImage> cuadros = new ArrayList<>();
        
        //caminar
        cuadros.add(personaje.iniciarPersonaje(0, 0, 35, 70));
        cuadros.add(personaje.iniciarPersonaje(38, 0, 35, 70));
        cuadros.add(personaje.iniciarPersonaje(75, 0, 38, 70));
        cuadros.add(personaje.iniciarPersonaje(115, 0, 40, 70));

        animacion = new Animacion(cuadros);
        animacion.iniciar();
        
        brincar = new Sonido("jump.wav");
        
        auxy = y;
    }
    
    public boolean moviendose() {        
        return enmovimiento;
    }
    
    public void mover(int ancho, int anchoimagen) {
        if(x<ancho-80){
            if(x<ancho/2){
                x += dx;
                auxx = x;
            }else if(findondo){
                x += dx;
            }else{
                if(auxx+(ancho/2)>anchoimagen){
                    findondo = true;
                }
                auxx += dx; 
            }
        }
        
    }
    
    public int obtienePosicion() {
        return auxx;
    }

    public int obtieneX() {
        return x;
    }

    public int obtieneY() {
        return y;
    }

    public Animacion obtienePersonaje() {
        return animacion;
    }
    
    public void presionaTecla(KeyEvent e) {


        int tecla = e.getKeyCode();

        /*if (tecla == KeyEvent.VK_LEFT) {
            dx = -1;
        }*/
        
        if (tecla == KeyEvent.VK_RIGHT) {
            dx = 1;
            animacion.avanzar();
            enmovimiento = true;
        }
        
        if (tecla == KeyEvent.VK_UP) {
            y = y - 15;
            animacion.brincar();
            brincar.reproduce();
        }
        
        /*
        if (tecla == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        */
    }
    
    public void liberaTecla(KeyEvent e) {
        
        int tecla = e.getKeyCode();

        /*if (tecla == KeyEvent.VK_LEFT) {
            dx = 0;
        }*/

        if (tecla == KeyEvent.VK_RIGHT) {
            dx = 0;
            animacion.reiniciar();
            enmovimiento = false;
        }
        
        if (tecla == KeyEvent.VK_UP) {
            y = auxy;
            animacion.reiniciar();
        }

        /*
        if (tecla == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        */
    }
    
}
