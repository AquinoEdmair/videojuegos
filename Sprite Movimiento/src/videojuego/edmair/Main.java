/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego.edmair;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author aquinoedmair
 */
public class Main extends JFrame{
    
    BufferedImage sprite;
    Animacion spriteImage;
    int posicionactual = 0;
    
    public Main(){
        setSize(700,350);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        CargaImagen imagen = new CargaImagen();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = imagen.cargarImagen("mario-jump.png");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sprite s = new Sprite(bufferedImage);
        
        ArrayList<BufferedImage> cuadros = new ArrayList<>();
        
        cuadros.add(s.iniciarSprite(0, 0, 90, 175));
        cuadros.add(s.iniciarSprite(80, 0, 90, 175));
        cuadros.add(s.iniciarSprite(200, 0, 90, 175));
        cuadros.add(s.iniciarSprite(300, 0, 90, 175));
        cuadros.add(s.iniciarSprite(400, 0, 90, 175));

        spriteImage = new Animacion(cuadros);
        spriteImage.defineVelocidad(100);
        spriteImage.iniciar();
    }
    
    Image image;
    Graphics gp;
        
    @Override
    public void paint(Graphics graphics){
        image = createImage(getWidth(), getHeight());
        gp = image.getGraphics();
        paintComponent(gp);
        graphics.drawImage(image, 0, 0, null);
    }
    
    public void paintComponent(Graphics g){
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("fondo.jpeg"));
        Image image2 = ii.getImage();
      
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image2, 0, 0, this);
      
        if(spriteImage != null){
            spriteImage.actualiza(System.currentTimeMillis());
            if(posicionactual >= 600){
                posicionactual = 0;
            }else{
                posicionactual+= 1;
            }
            g.drawImage(spriteImage.sprite, posicionactual, 150, 90, 175, null);
        }
        repaint();
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
