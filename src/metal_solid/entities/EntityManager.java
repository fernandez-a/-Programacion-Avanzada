package metal_solid.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import metal_solid.Handler;
import metal_solid.entities.creatures.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
	}
	
	public void tick() {
		for(int i = 0; i< entities.size(); i++ ) {
			Entity e = entities.get(i);
			e.tick();
		}
		player.tick();
	}
	
	public void render(Graphics g) {
		for(Entity e: entities) {
			e.render(g);
		}
		player.render(g);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	//Getter Setter

	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * @param pone el handler al pasado por parametro
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * @return el jugador
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param pone al jugador al pasado por parametro
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return Nos devuelve el arrayList de entidades
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	/**
	 * @param Pone las entidades a las pasadas por parametro
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
