package metal_solid.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Clase que carga las imagenes
 * @author Alejandro
 *
 */


public class ImageLoader {
	/**
	 * Funcion para leer el path de una imagen y devolverla como una Imagen
	 * 
	 * @return Devuelve una imagen
	 */
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
