package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectile extends GameObject{
	
	Handler handler;
	Color color = Color.WHITE;

	/*
	 * Constructor de la clase que recibe la posicion en que se crea el objeto, su id y el handler
	 */
	public Projectile(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	/*
	 * Este metodo tick define la velocidad del movimiento del proyectil, invoca el metodo
	 * collision(), y si su posicion en y llega a ser menor que 0, se elimina el objeto.
	 */
	public void tick() {
		y -= 1.5;
		collision();
		if (y<0) {
			handler.object.removeThis(this);
		}
		
	}

	/* 
	 * parte visual del enemigos, se dibuja un rectangulo y se le da color
	 * @Override Adaptado a las dimensiones y color del proyectil
	 */
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval( (int)x,(int) y, 8, 8);
		
	}

	/* Metodo que retorna el rectangulo o en otras palabras los bordes del objeto
	 * @Override Adaptado a las dimensiones del proyectil
	 * @return Rectangle 
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	
	/*
	 * Metodo que compara la posicion del proyectil con todos los objetos del
	 * juego y si este se interseca con un enemigo cambia de color y 
	 */
	private void collision() {
		for(int i = 0; i < handler.object.getLength(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID()==ID.Enemy){
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					color = Color.BLACK;
				}
			}
		}
	}

}
