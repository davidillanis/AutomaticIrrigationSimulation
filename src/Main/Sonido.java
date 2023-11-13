
package Main;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

/*@author LENOVO::DAVID ABEL*/
public class Sonido {
    public static Clip clip_agua, clip_motor;

    public Sonido() {
        ClipIniciar();
    }
    private void ClipIniciar(){
        String ruta_agua, ruta_motor;
        ruta_agua="/Song/agua.wav";
        ruta_motor="/Song/motor.wav";
        try {
            clip_agua=AudioSystem.getClip();
            clip_agua.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta_agua)));
            clip_motor=AudioSystem.getClip();
            clip_motor.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta_motor)));
        } catch (Exception e) {System.out.println("El clip no se encontro "+e);}
    }
}
