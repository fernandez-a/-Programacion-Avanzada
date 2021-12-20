package metal_solid;

import metal_solid.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	public Handler(Game game) {
		this.game = game;
	}
	public Game getGame() {
		return game;
	}
	/**
	 * @param Nos pondra  el juego al juego pasado por parametro
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return el mundo
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param Nos pondrá el mundo al mundo pasado por parametro
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	

}
