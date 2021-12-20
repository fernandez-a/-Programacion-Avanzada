package metal_solid.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import metal_solid.ui.UImanager;
/**
 * Clase que llevara a cabo el manejo del raton que seran utilizadas en el juego
 * @author Alejandro
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener{
	private boolean leftPressed,rightPressed;
	private int mouseX, mouseY;
	private UImanager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UImanager uiManager) {
		this.uiManager = uiManager;
	}
	/**
	 * @return si el boton izquierdo esta presionado
	 */
	public boolean isLeftPressed() {
		return leftPressed;
	}

	/**
	 * @return si el boton derecho esta presionado
	 */
	public boolean isRightPressed() {
		return rightPressed;
	}

	/**
	 * @return coordenada X del raton
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * @return coordenada Y del raton
	 */
	public int getMouseY() {
		return mouseY;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		

		if(uiManager != null) {
			uiManager.onMouseMove(e);
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}
		
		if(uiManager != null) {
			uiManager.onMouseRelease(e);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
