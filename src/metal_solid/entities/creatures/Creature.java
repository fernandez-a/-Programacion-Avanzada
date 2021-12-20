package metal_solid.entities.creatures;


import metal_solid.Handler;
import metal_solid.entities.Entity;
import metal_solid.tiles.Tile;

/**
 * Clase que extiende la clase Entidad, que utilizaremos para crear nuestros personajes, y posteriormente futuros enemigos
 * @author Alejandro
 *
 */
public abstract class Creature extends Entity{
	

	public static final float DEFAULT_SPEED = 1.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected boolean isLader = false;
	protected boolean go_up = true;
	protected boolean falling = true;
	protected boolean jumping = false; 
	protected static final float max_speed = 6f;
	protected float gravity = 3f;
	protected float health = 30;


	protected float speed;
	protected float xMove,yMove;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler,x, y,width,height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	public void move() {
		moveX();
		moveY();
	}

	/**
	 * Funcion para movimiento en el eje X tanto a la derecha como hacia la izquierda
	 */
	public void moveX() {
		if(xMove > 0 ) {
			
			int tx = (int) (x +xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) && ((!collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)))) {
				x += xMove;
			}
			else if((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) && ((collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)))) {
				x += xMove;
				health -= 0.02;
			}
			else {
				x = tx * Tile.TILEWIDTH - bounds.width - 1; //convertir a pixeles
			}
		}else if(xMove < 0) {
			int tx = (int) (x +xMove + bounds.x) / Tile.TILEWIDTH;
			
			if((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) || ((collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)))) {
				x += xMove;
			}
			else if((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) && ((collisionWithWater(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && collisionWithWater(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)))) {
				x += xMove;
				health -= 0.02;
			}
			else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	/**
	 * Funcion para movimiento en el eje Y tanto hacia arriba como hacia abajo
	 */
	public void moveY() {
		//Movimiento hacia arriba
		if(yMove < 0 ) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			//No hay colision
			if((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH,ty))){
				//isLader = true;
				y += yMove;
			}
			else if((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH,ty))){
				//isLader = true;
				y += yMove;
			}
			else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		//Movimiento hacia abajo
		}else if(yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) && 
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH,ty)) {
				y += yMove;
			}
			
			else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
		
	}
	/**
	 * Funcion que utilizaremos para comprobar si hay una colision con el tile
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	/**
	 * Funcion que utilizaremos para comprobar si hay una colision con la bandera
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithFlag(int x, int y) {
		return handler.getWorld().getTile(x, y).isFlag();
	}
	/**
	 * Funcion que utilizaremos para comprobar si hay una colision con el agua
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithWater(int x, int y) {
		return handler.getWorld().getTile(x, y).isWater();
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	protected boolean collisionWithLadder(int x, int y) {
		return handler.getWorld().getTile(x, y).isLadder();
	}

	/**
	 * @return the health
	 */
	public float getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(float health) {
		this.health = health;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}


	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	/**
	 * @return the falling
	 */
	public boolean isFalling() {
		return falling;
	}
	/**
	 * @param falling the falling to set
	 */
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	/**
	 * @return the jumping
	 */
	public boolean isJumping() {
		return jumping;
	}
	/**
	 * @param jumping the jumping to set
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	
	
	
}
