package metal_solid.state;

import java.awt.Graphics;

/*
 * Patron de comportamiento de estados
 */
import metal_solid.Handler;
/**
 * Clase abastracta Estado siguiendo el patron de comportamiendo de estados, que sera extendida por los estados futuros
 * @author Alejandro
 *
 */
public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
 