package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque escalera, solido
 */

import metal_solid.gfx.Assets;

public class Ladder_Broken_Solid extends Tile{

	public Ladder_Broken_Solid(int index,int id) {
		super(Assets.ladder[index], id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}
	@Override
	public boolean isLadder()
	{
		return false;
	}
}
