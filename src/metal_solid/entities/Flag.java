package metal_solid.entities;

/**
 * Codigo no Implementado, pero que se iba a utilizar para crear una bandera que seria una entidad estatica
 */

import java.awt.Graphics;

import metal_solid.Handler;
import metal_solid.tiles.Tile;
import metal_solid.gfx.Assets;
public class Flag extends StaticEntity {

	public Flag(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT );
	}

	@Override
	public void tick() {		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flag,width*2,height*2,null);
	}

}
