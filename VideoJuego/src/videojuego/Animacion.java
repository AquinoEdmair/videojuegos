/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author aquinoedmair
 */
public class Animacion {
    
    ArrayList<BufferedImage> cuadros;
    BufferedImage sprite;    
    private int cuadroActual;
    
    public Animacion(ArrayList<BufferedImage> cuadros){
        this.cuadros = cuadros;
    }
    
    public void iniciar(){
        cuadroActual = 0;
        sprite = cuadros.get(cuadroActual);
    }
    
    public void brincar(){
        cuadroActual = this.cuadros.size()-1;
        sprite = cuadros.get(cuadroActual);
    }
    
    public void avanzar(){
        if(cuadroActual<cuadros.size()-2){
            cuadroActual++;
        }else{
            cuadroActual = 0;
        }
        sprite = cuadros.get(cuadroActual);
    }
    
    public void reiniciar(){
        cuadroActual = 0;
        sprite = cuadros.get(cuadroActual);
    }
    
}
