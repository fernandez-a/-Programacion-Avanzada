package metal_solid.worlds;

import java.awt.Graphics;

import metal_solid.tiles.Tile;
import metal_solid.Handler;
import metal_solid.Utils;
import metal_solid.entities.EntityManager;
import metal_solid.entities.creatures.Player;
import metal_solid.gfx.Assets;

/**
 * Clase mundo, en la que sse inicializa todos los players y el mundo que sera el que se jugara
 * @author Alejandro
 *
 */

public class World {
	
	private Handler handler;
	private Utils util;
	private int width, height;
	private int spawnx, spawny;
	private int[][] tiles;
	private EntityManager entityManager;
	
	public World(Handler handler,String path,int opc) {
		this.handler = handler;
		this.util = new Utils();
		if(opc == 1) {
			entityManager = new EntityManager(handler, new Player(handler,100,100,Assets.animationsCharacter1));
		}
		else if(opc == 2) {
			entityManager = new EntityManager(handler, new Player(handler,100,100,Assets.animationsCharacter2));
		}
		else if(opc ==3) {
			entityManager = new EntityManager(handler, new Player(handler,100,100,Assets.animationsCharacter3));
		}
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnx);
		entityManager.getPlayer().setY(spawny);
	}
	
	public void tick() {
		entityManager.tick();
	}
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGame().getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,(handler.getGame().getGameCamera().getxOffset() + handler.getGame().getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGame().getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,(handler.getGame().getGameCamera().getyOffset() + handler.getGame().getHeight()) / Tile.TILEHEIGHT + 1);
		
		
		for(int y= yStart; y < yEnd; y++){
		  	for(int x= xStart; x < xEnd; x++) {
		  		getTile(x, y).render(g,(int) (x * Tile.TILEWIDTH - handler.getGame().getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGame().getGameCamera().getyOffset()));
		  	}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.floortile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.floortile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		  String file = this.util.loadFileAsString(path);
		  String[] tokens = file.split("\\s+");
		  width = Utils.parseInt(tokens[0]);
		  height = Utils.parseInt(tokens[1]);
		  spawnx = Utils.parseInt(tokens[2]);
		  spawny  = Utils.parseInt(tokens[3]);
		  
		  tiles = new int[width][height];
		  for(int y = 0;y < height;y++) {
		   for(int x = 0;x < width;x++) { 
		    tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
		   }
		  }
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	
}
