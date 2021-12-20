package metal_solid.state;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;



import javax.swing.ImageIcon;
import metal_solid.Handler;
import metal_solid.gfx.Assets;
import metal_solid.gfx.AudioPlayer;
import metal_solid.ui.ClickListener;
import metal_solid.ui.UImanageCharacter;
import metal_solid.ui.UImanager;
/**
 * Clase en la que se crea un estado de la maquina de estados, que sera el menu de seleccion de los personajes
 * @author Alejandro
 *
 */
public class SelectCharact extends State{
	private Image image;
	private Image gif1;
	private Image gif2;
	private Image gif3;
	private AudioPlayer bgMusic;
	UImanager uiManager;
	public SelectCharact(Handler handler) {
		super(handler);
		uiManager = new UImanager(handler);
		bgMusic = new AudioPlayer("/sounds/Soundtrack.wav");
		image = new ImageIcon(getClass().getResource("/tiles/Background.png")).getImage();
		gif1 = new ImageIcon(getClass().getResource("/gifs/charac1.gif")).getImage();
		gif2 = new ImageIcon(getClass().getResource("/gifs/charac2.gif")).getImage();
		gif3 = new ImageIcon(getClass().getResource("/gifs/charac3.gif")).getImage();
		handler.getGame().getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UImanageCharacter(140,200, 90,90, Assets.icon1, new ClickListener() {
			/**
			 * Soobrescribimos la funcion abstracta que nos permitira saber si hemosclicado el icono correcto
			 */
			@Override
			public void onClick() {
				handler.getGame().getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}
		}));
		uiManager.addObject(new UImanageCharacter(280,200,90,90, Assets.icon2, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getGame().getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState2);
				
			}
		}));
		uiManager.addObject(new UImanageCharacter(420,200,90,90, Assets.icon3, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getGame().getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState3);
				
			}
		}));
		
	}
	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,0,0,handler.getGame().getWidth(), handler.getGame().getHeight(),null);
		g.drawImage(gif1,140,350,90,90,null);
		g.drawImage(gif2,280,350,90,90,null);
		g.drawImage(gif3,420,350,90,90,null);
		g.setFont(new Font("Ink Free",Font.BOLD,50));
		g.setColor(Color.white);
		g.drawString("Select Character",140,170);
		uiManager.render(g);
	}

}