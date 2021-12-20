package metal_solid.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import metal_solid.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x,y;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler,float x, float y,int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		
		this.height = height;
		
		bounds = new Rectangle(0,0,width,height);
	}
	
	public abstract void tick() ;
	
	public abstract void render(Graphics g);

	/**
	 * @return x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param pone la x a la pasada por parametro
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param pone la y a la pasada por parametro
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return el ancho
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param pone el ancho al pasado por parametro
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return la altura
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param pone la altura a la pasada por parametro
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
