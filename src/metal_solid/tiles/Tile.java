package metal_solid.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * Clase en la que se inicializan todos los bloques, que posteriormente utilizaremos para crear nuestro mundo
 */
public class Tile {

	public static final int TILEWIDTH = 64,
	 TILEHEIGHT = 64;
	
	
	public static Tile[] tiles = new Tile[256];
	public static Tile floortile = new FloorTile(0,0);
	public static Tile floor1 = new FloorTile(0,0);
	public static Tile free = new Free(6);
	public static Tile floor2 = new FloorTile(1,7);
	public static Tile water1 = new WaterTile(0,8);
	public static Tile water2 = new WaterTile(1,9);
	public static Tile water3 = new WaterTile(2,10);
	public static Tile water4 = new WaterTile(3,11);
	public static Tile floor3 = new FloorTile(2,12);
	public static Tile ladder_b1 = new Ladder_Broken_Solid(0,13);
	public static Tile ladder_b2 = new Ladder_Broken_Solid(1,14);
	public static Tile ladder_b3 = new Ladder_Broken(2,15);
	public static Tile ladder1 = new Ladder(3,16);
	public static Tile ladder2 = new Ladder(4,17);
	public static Tile ladder3 = new Ladder(5,18);
	public static Tile air2 = new Air(1,21);//21
	public static Tile air3 = new Air(2,22);//22
	public static Tile air4 = new Air(3,23);//23
	public static Tile floor4 = new FloorTile(3,24);
	public static Tile floor5 = new FloorTile(4,25);
	public static Tile floor6 = new FloorTile(5,26);
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGHT,null);
	}
	
	public boolean isSolid()
	{
		return false;
	}
	public boolean isFlag()
	{
		return false;
	}
	public boolean isWater()
	{
		return false;
	}
	public boolean isLadder()
	{
		return false;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}

