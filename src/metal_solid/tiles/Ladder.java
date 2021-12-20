package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque escaler
 */

import metal_solid.gfx.Assets;

public class Ladder extends Tile{

	public Ladder(int index,int id) {
		super(Assets.ladder[index], id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
	@Override
	public boolean isLadder()
	{
		return true;
	}
}
