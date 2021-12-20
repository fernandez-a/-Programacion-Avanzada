package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque escalera no solido
 */

import metal_solid.gfx.Assets;

public class Ladder_Broken extends Tile{

	public Ladder_Broken(int index,int id) {
		super(Assets.ladder[index], id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
	
	@Override
	public boolean isLadder()
	{
		return false;
	}
}
