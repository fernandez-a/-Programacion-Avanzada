package metal_solid.state;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import metal_solid.Handler;
import metal_solid.worlds.World;
/**
 * Clase en la que se crea un estado de la maquina de estados, que sera el segundo nivel
 * @author Alejandro
 *
 */
public class Level2 extends State{
	
	private Image image;
	private World world;
	protected int opc;
	public Level2(Handler handler) {
		super(handler);
		//this.opc = handler.getGame();
		world = new World(handler, "/worlds/level2",opc);
		image = new ImageIcon(getClass().getResource("/tiles/Background.png")).getImage();
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,0,0,handler.getGame().getWidth(), handler.getGame().getHeight(),null);
		world.render(g);
	}

}
