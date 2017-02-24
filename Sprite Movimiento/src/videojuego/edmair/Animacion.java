/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego.edmair;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author aquinoedmair
 */
public class Animacion {
    
    ArrayList<BufferedImage> cuadros;
    BufferedImage sprite;
    
    private volatile boolean corriendo = false;
    private long tiempoespera, velocidad;
    private int cuadroActual, cuadroPausado;
    
    public Animacion(ArrayList<BufferedImage> cuadros){
        this.cuadros = cuadros;
    }
    
    public void defineVelocidad(long velocidad){
        this.velocidad = velocidad;
    }
    
    public void actualiza(long tiempo){
        if(corriendo) {            
            if(tiempo - tiempoespera >= velocidad){
                cuadroActual++;
                try {
                    sprite = cuadros.get(cuadroActual);
                } catch (IndexOutOfBoundsException boundsException) {
                    cuadroActual = 0;
                    sprite = cuadros.get(cuadroActual);
                }
                tiempoespera = tiempo;
            }
        }
        
    }
    
    public void iniciar(){
        corriendo = true;
        tiempoespera = 0;
        cuadroActual = 0;
        cuadroPausado = 0;
    }
    
    public void detener(){
        corriendo = false;
        tiempoespera = 0;
        cuadroActual = 0;
        cuadroPausado = 0;
    }
    
    public void pausa(){
        cuadroPausado = cuadroActual;
        corriendo = false;
    }
    
    public void resumir(){
        cuadroActual = cuadroPausado;
        corriendo = true;
    }
    
}
