package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -1285670934175365101L;

	public static final int WIDTH = 720, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	
	private static Handler handler;
	private static HUD hud;
	private Spawn spawner;
	private ListHandler listHandler;
	
	public static int playerPositionX = WIDTH/2, playerPositionY = HEIGHT-100;
	static Player myPlayer = new Player(playerPositionX, playerPositionY, ID.Player);
	
	/*constructor del juego, en el se instancia las otras clases, se crea la ventana y se añade un KeyListener
	 */
	public Game() {
		hud = new HUD();
		
		handler = new Handler();
		
		listHandler = new ListHandler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "Space Invaders", this);
		
		spawner = new Spawn(handler, hud, listHandler);
		
		handler.addObject(myPlayer);
		
	}
	
	//funcion encargada del inicio del Thread 
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	
	//funcion encargada de finiquitar el Thread
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//todos los metodos tick son invocados aqui
	private void tick() {

		hud.tick();
		
		handler.tick();
		
		spawner.tick();
		
		listHandler.tick();
	
		
	}

	//Metodo que instancia proyectiles
	public static void shoot() {
		handler.addObject(new Projectile(myPlayer.getX()+12, myPlayer.getY(), ID.Projectile, handler));
		
	}
	
	//Se encarga de la parte grafica, visual del juego.
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	//Se encarga de recibir una variable y delimitarla con los ints que reciba
	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
					
	}
	
	public static void killBoss() {
		hud.score(hud.getScore()+5);
	}

	//metodo main
	public static void main(String args[]){
		
		new Game(); 
	}
}
