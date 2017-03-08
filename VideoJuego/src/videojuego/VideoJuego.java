/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author aquinoedmair
 */
public class VideoJuego extends JFrame{
    
    public VideoJuego() {
        initUI();
    }
    
    private void initUI() {

        add(new Pantalla());
        
        setSize(408, 268);
        setResizable(false);
        
        setTitle("VideoJuego");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VideoJuego videojuego = new VideoJuego();
                videojuego.setVisible(true);
            }
        });
    }
    
}
