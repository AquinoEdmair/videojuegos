/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author aquinoedmair
 */
public class Pantalla extends JPanel implements ActionListener{
    
    private Timer tiempo;
    private Sprite sprite;
    private final int RETRASO = 10;
    private Sonido musica;
    private BufferedImage imagenFondo;
    private int aux_x;
    
    public Pantalla() {
        iniciaPantalla();
    }
    
    private void iniciaPantalla() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        sprite = new Sprite(40,162);
        
        CargaImagen fondoImagen = new CargaImagen();
        try {
            imagenFondo = fondoImagen.cargarImagen("escenario-mario.jpg");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        tiempo = new Timer(RETRASO, this);
        tiempo.start();        
        
        musica = new Sonido("musicamario.wav");
        musica.reproduceCiclo();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        pintaSprite(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void pintaSprite(Graphics g) {     
        Graphics2D g2d = (Graphics2D) g;
       
        
        if(sprite.obtieneX()<getWidth()/2){
            g2d.drawImage(imagenFondo, getX(), getY(), imagenFondo.getWidth(), imagenFondo.getHeight(), null);
            aux_x = getX();
        }else{
            if(sprite.obtienePosicion() + ((getWidth()/2)/2) - (getWidth()/2)>getWidth()){
                g2d.drawImage(imagenFondo, aux_x, getY(), imagenFondo.getWidth(), imagenFondo.getHeight(), null);
            }else{
                if(imagenFondo.getWidth() - sprite.obtienePosicion()==getWidth()){
                    g2d.drawImage(imagenFondo, aux_x, getY(), imagenFondo.getWidth(), imagenFondo.getHeight(), null);
                }else{
                    if(sprite.moviendose()){
                        g2d.drawImage(imagenFondo, aux_x, getY(), imagenFondo.getWidth(), imagenFondo.getHeight(), null);
                        aux_x = aux_x - 1;
                    }else{
                        g2d.drawImage(imagenFondo, aux_x, getY(), imagenFondo.getWidth(), imagenFondo.getHeight(), null);
                    }
                }
            }
        }
        
        if(sprite.obtienePersonaje()!=null){
            g2d.drawImage(sprite.obtienePersonaje().sprite, sprite.obtieneX(), sprite.obtieneY(), this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        sprite.mover(getWidth(), imagenFondo.getWidth());
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            sprite.liberaTecla(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            sprite.presionaTecla(e);
        }
    }
    
}
