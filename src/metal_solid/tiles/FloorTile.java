package metal_solid.tiles;



import metal_solid.gfx.Assets;

/**
 * Clase en la que se crea un bloque suelo, de tipo solido False
 */
public class FloorTile extends Tile{

	public FloorTile(int index,int id) {
		super(Assets.floor1[index], id);
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
