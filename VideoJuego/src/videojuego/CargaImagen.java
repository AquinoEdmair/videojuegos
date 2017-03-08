/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author aquinoedmair
 */
public class CargaImagen {
    
    public BufferedImage cargarImagen(String imagen) throws IOException{
        URL url = this.getClass().getResource(imagen);
        BufferedImage bufferedImage = ImageIO.read(url);
        return bufferedImage;
    }
}