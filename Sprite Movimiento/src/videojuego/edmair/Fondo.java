/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego.edmair;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author aquinoedmair
 */
public class Fondo extends JPanel {
  private final Image image;

  public Fondo(String fondo){
      ImageIcon ii = new ImageIcon(this.getClass().getResource(fondo));
      image = ii.getImage();
  }

  @Override
  public void paint(Graphics g){
      Graphics2D g2d = (Graphics2D)g; // Convertimos a g de Graphics a Graphics2D
      g2d.drawImage(image, 0, 0, this);
  }
}
