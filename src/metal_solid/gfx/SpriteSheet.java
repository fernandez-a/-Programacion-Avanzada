package metal_solid.gfx;

import java.awt.image.BufferedImage;
/**
 * Clase que usaremos para cortar las imagenes con un ancho y alto personalizados
 * @author Alejandro
 *
 */
public class SpriteSheet {

	private BufferedImage  sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	/*
	 * Funcion que utilzaremos para cortar las imagenes y obtener imagenes que podremos utilizar como BufferedImage
	 * 
	 * @return BufferedImage
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
		
	}
	
}
