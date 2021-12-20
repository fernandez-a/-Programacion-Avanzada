package metal_solid.entities;

import metal_solid.Handler;
/**
 * 
 * Clase Que nos ayuda a crear todas las entidades estaticas
 *
 */
public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
