package metal_solid.tiles;

/**
 * Clase en la que se crea un bloque aire
 */
import metal_solid.gfx.Assets;

public class Air extends Tile{

	public Air(int index,int id) {
		super(Assets.air[index], id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
