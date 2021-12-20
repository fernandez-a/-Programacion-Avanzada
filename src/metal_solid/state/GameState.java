package metal_solid.state;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import metal_solid.Handler;
import metal_solid.worlds.World;
/**
 * Clase en la que se crea un estado de la maquina de estados, que sera el primer nivel
 * @author Alejandro
 *
 */
public class GameState extends State{
	
	private Image image;
	private World world;
	protected int opc;
	public GameState(Handler handler,int opc) {
		super(handler);
		this.opc = opc;
		world = new World(handler, "/worlds/world1.txt",opc);
		image = new ImageIcon(getClass().getResource("/tiles/Background.png")).getImage();
		handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		world.tick();
		if(handler.getGame().getKeyManager().escape) {
			State.setState(handler.getGame().selectState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,0,0,handler.getGame().getWidth(), handler.getGame().getHeight(),null);
		world.render(g);
	}

	/**
	 * @return nos devolvera la opcion que sera utilizada para comprobar la seleccion de personaje
	 */
	public int getOpc() {
		return opc;
	}

}
