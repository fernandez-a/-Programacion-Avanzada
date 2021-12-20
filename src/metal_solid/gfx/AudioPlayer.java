package metal_solid.gfx;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *  Clase que nos permitira reproducir audios, esta clase la instanciaremos donde queramos usar la musica
 * @author Alejandro
 *
 */
public class AudioPlayer {
	private Clip clip;

	public AudioPlayer(String path) {
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource(path));
			clip = AudioSystem.getClip();
			clip.open(sound);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stop() {
		if(clip.isRunning()) clip.stop();
	}
}
