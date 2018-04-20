package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	/*
	 * constructor que recibe la id, la posicion en x y la posicion en y que es creado
	 */
	public Player(double x, double y, ID id) {
		super(x, y, id);
		
		
	}

	/*
	 * etse metodo tick altera la posicion en razon de la velocidad y delimita el movimiento
	 * del jugador para que no se salga de la pantalla
	 */
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x, 0, Game.WIDTH-48);
	}

	/*
	 * @Override Adaptado a las dimensiones del jugador y color
	 * parte visual del objeto jugador, se dibuja su figura y se le da un color
	 */
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)x,(int) y, 32, 32);
		
	}

	/* Metodo que retorna el rectangulo o en otras palabras los bordes del objeto
	 * @Override Adaptado a la dimension del jugador
	 * @return Rectangle 
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}
	

}
