package metal_solid;

/**
 * Clase del juego, en la que se instancian multiples parametros
 */
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import metal_solid.display.Display;
import metal_solid.gfx.Assets;
import metal_solid.gfx.GameCamera;
import metal_solid.input.KeyManager;
import metal_solid.input.MouseManager;
import metal_solid.state.GameState;
import metal_solid.state.SelectCharact;
import metal_solid.state.State;

public class Game implements Runnable {
	
	private Display display;
	
	private int width, height;
	
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	private Assets assets;
	//Estados
	public State gameState;
	public State gameState2;
	public State gameState3;
	public State menuState;
	public State selectState;
	
	//Entrada de teclado
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camara
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(int width,int height,String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
	}
	/**
	 * Funcion que inicializa nuestros parametros
	 */
	private void init() {
		assets = new Assets();
		display = new Display(width,height,title);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
		
		gameState = new GameState(handler,1);
		gameState2 = new GameState(handler,2);
		gameState3 = new GameState(handler,3);
		selectState = new SelectCharact(handler);
		State.setState(selectState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	/**
	 * Funcion para renderizar el canvas
	 */
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
			
		}
		g = bs.getDrawGraphics();
		//Clear Screan
		g.clearRect(0, 0, width, height);
		//Aqui dibujaremos

		if(State.getState() != null)
			State.getState().render(g);
		
		
		//Aqui dejaremos de dibujar
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta --;
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks " + ticks);
				ticks = 0;
				timer = 0;
			}
		
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	/**
	 * @return Nos devolvera el ancho
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @return Nos devolvera el alto
	 */
	public int getHeight() {
		return height;
	}
	
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}