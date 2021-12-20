package metal_solid.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class Uiobject {
	
	protected float x,y;
	protected int width,height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	public Uiobject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int)x,(int)y, width,height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(),e.getY())) {
			hovering = true;
		}
		else
			hovering = false;
	}
	
	public void onMouseRelease(MouseEvent e) {
		if(hovering) {
			onClick();
		}
	}
	//Getter Setters
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the widht
	 */
	public int getWidht() {
		return width;
	}

	/**
	 * @param widht the widht to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the hovering
	 */
	public boolean isHovering() {
		return hovering;
	}

	/**
	 * @param hovering the hovering to set
	 */
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
}
