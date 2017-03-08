/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author aquinoedmair
 */
public class Sonido {
    
    private AudioClip sonido;
    private final String audio;
    
    public Sonido(String audio) {
        this.audio = audio;
        iniciaSonido();
    }

    private void iniciaSonido() {
        URL url = Sonido.class.getResource(audio);
	sonido = Applet.newAudioClip(url);
    }
    
    public void reproduce() {        
        sonido.play();
    }

    public void reproduceCiclo() {        
        sonido.loop();
    }
    public void detiene() {
        sonido.stop();
    }
}
