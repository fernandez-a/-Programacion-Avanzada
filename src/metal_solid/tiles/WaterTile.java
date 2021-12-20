package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque agua
 */
import metal_solid.gfx.Assets;

public class WaterTile extends Tile{

	public WaterTile(int index,int id) {
		super(Assets.water[index], id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
	
	@Override
	public boolean isWater()
	{
		return true;
	}

}
