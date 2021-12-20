package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque libre
 */

import metal_solid.gfx.Assets;

public class Free extends Tile{

	public Free(int id) {
		super(Assets.free, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}

}
