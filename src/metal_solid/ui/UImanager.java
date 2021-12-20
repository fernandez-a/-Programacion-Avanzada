package metal_solid.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import metal_solid.Handler;

public class UImanager {
	
	private Handler handler;
	private ArrayList<Uiobject> objects;

	public UImanager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<Uiobject>();
	}
	
	public void tick() {
		for(Uiobject o: objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Uiobject o: objects) {
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for(Uiobject o: objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(Uiobject o: objects) {
			o.onMouseRelease(e);
		}
	}
	
	public void addObject(Uiobject o) {
		objects.add(o);
	}
	
	public void deleteObject(Uiobject o) {
		objects.remove(o);
	}

	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * @return the objects
	 */
	public ArrayList<Uiobject> getObjects() {
		return objects;
	}

	/**
	 * @param objects the objects to set
	 */
	public void setObjects(ArrayList<Uiobject> objects) {
		this.objects = objects;
	}
	
}
