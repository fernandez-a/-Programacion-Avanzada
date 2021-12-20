package metal_solid.entities.creatures;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import metal_solid.Handler;
import metal_solid.gfx.Animations;
/**
 * Funcion que extiende la clase creatura, y en la que se define el jugador
 * @author Alejandro
 *
 */
public class Player extends Creature{
	
	private Animations animRight;
	private Animations animLeft;
	private Animations animClimb;

	public Player(Handler handler, float x, float y,ArrayList<BufferedImage[]>animations) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 18;
		bounds.y = 40;
		bounds.width = 20;
		bounds.height = 18;
		

		animRight = new Animations(130, animations.get(0));
		animLeft = new Animations(130, animations.get(1));
		animClimb = new Animations(130, animations.get(2));

		
	}
	
	@Override
	public void tick() {
		//Animations
		animRight.tick();
		animLeft.tick();
		animClimb.tick();
		//Movement
		getInput();
		move();
		handler.getGame().getGameCamera().centerOnEntity(this);
	}

	/**
	 * Funcion que utilizaremos para obtener que teclas se estan pulsando
	 */
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(falling || jumping) {
			yMove += gravity;
		}
		if(handler.getGame().getKeyManager().space) {
			//xMove = +1;
			yMove = -speed;
			//falling = true;
		}
		if(handler.getGame().getKeyManager().down) {
			go_up = false;
			yMove = speed;
		}
		if(handler.getGame().getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getGame().getKeyManager().right) {
			xMove = speed;
		}
		if(handler.getGame().getKeyManager().Aright) {
			xMove = speed;

		}
		if(handler.getGame().getKeyManager().left) {
			xMove = -speed;
		}
			
	}
	
	
	 @Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGame().getGameCamera().getxOffset()), (int) (y - handler.getGame().getGameCamera().getyOffset()),width,height, null);
	}
	 
	 /**
	  * Funcion que nos devolvera la imagen de la animacion imagen por imagen y asi poder visualizar por pantalla lo que acabara siendo la animacion
	  *  
	  * @return BufferedImage
	  */
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		
		else if(xMove > 0)
			return animRight.getCurrentFrame();
		
		else if(handler.getGame().getKeyManager().space)
			return animRight.getCurrentFrame();
		
		else if(yMove < 0 && isLader) {
			return animClimb.getCurrentFrame();
		}
	
		else
			return animRight.getCurrentFrame();
		
	}
	

}
