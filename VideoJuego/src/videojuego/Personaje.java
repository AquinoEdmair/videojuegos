/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.image.BufferedImage;

/**
 *
 * @author aquinoedmair
 */
public class Personaje {
    
    public BufferedImage sprite;
    
    public Personaje(BufferedImage bufferedImage){
        this.sprite = bufferedImage;
    }
    
    public BufferedImage iniciarPersonaje(int x, int y, int ancho, int alto){
        BufferedImage bufferedImage = sprite.getSubimage(x, y, ancho, alto);
        return bufferedImage;
    }
    
}
