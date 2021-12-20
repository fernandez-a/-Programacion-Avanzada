package metal_solid.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Clase que llevara a cabo el manejo de las teclas que seran utilizadas en el juego
 * @author Alejandro
 *
 */
public class KeyManager implements KeyListener{

	private boolean[]  keys;
	public boolean down,left,right,space,up,escape;
	public boolean Adown,Aleft,Aright,Aspace,Aup,attac1;
	
	
	public KeyManager() {
		keys = new boolean[256];
		
		
	}
	
	
	public void tick() {

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		attac1 = keys[KeyEvent.VK_1];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		escape = keys[KeyEvent.VK_ESCAPE];
		
		Aup = keys[KeyEvent.VK_W];
		Adown = keys[KeyEvent.VK_S];
		attac1 = keys[KeyEvent.VK_1];
		Aleft = keys[KeyEvent.VK_A];
		Aright = keys[KeyEvent.VK_RIGHT];
		Aspace = keys[KeyEvent.VK_SPACE];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
