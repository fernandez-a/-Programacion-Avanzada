package metal_solid.gfx;


import metal_solid.Handler;
import metal_solid.entities.Entity;
import metal_solid.tiles.Tile;
/**
 * Clase que usaremos para crear la camara que usaremos para mover al personaje y el mapa
 * @author Alejandro
 *
 */
public class GameCamera {
	
	private Handler handler;
	private float xOffset,yOffset;
	
	public GameCamera(Handler handler,float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getGame().getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getGame().getWidth();
		}
		if(yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT- handler.getGame().getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT- handler.getGame().getHeight();
		}
	}
	
	public void centerOnEntity(Entity e) {
		xOffset  = (e.getX() - handler.getGame().getWidth() / 2) + (e.getWidth()/2);
		yOffset  = (e.getY() - handler.getGame().getHeight() / 2) + (e.getHeight()/2);
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	/**
	 * @return el xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param Pondra el xOffset al pasado por parametro
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return el yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param Pondra el xOffset al pasado por parametro
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
