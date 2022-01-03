package modelo;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;

public class Reproductor1 {

    public BasicPlayer player;

    public Reproductor1() {
        player = new BasicPlayer();
    }

    public boolean Play() throws Exception {
        player.play();
        return true;
    }

    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));

    }

    public void Stop() throws Exception {
        player.stop();
    }

    public static void main(String args[]) throws Exception {
        Reproductor1 y = new Reproductor1();
        y.AbrirFichero("D:/temas java/Alice In Chains - Down in a Hole (MTV Unplugged - HD Video).mp3");
        y.Play();
        
    }
}
