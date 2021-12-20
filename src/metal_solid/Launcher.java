package metal_solid;

/**
 * 
 * @author Alejandro
 *
 */

public class Launcher {
	/**
	 * Main class, mediante la cual se correra el juego.
	 */
	public static final int WIDTH = 640;
	public static final int	HEIGHT = WIDTH / 12 * 9;
	
	
	public static void main(String args[]) {
		Game game = new Game(WIDTH, HEIGHT, "Platformer");
		game.start();
	}
	
	
	
	
}
