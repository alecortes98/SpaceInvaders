package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private int health = 10; 
	private Handler handler;
	private Color color = Color.YELLOW;
	private final int initialX =(int) x;
	private HUD hud;
	
	/*
	 * Constructor de la clase que recibe la posicion en que se crea el objeto, su id y el handler
	 */
	public BasicEnemy(double x, double y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		this.hud = hud;
		this.handler = handler;
	}
	
	/*
	 * Este metodo tick define la velocidad y la direccion del enemigo, invoca el metodo
	 * colision, y si su atributo health llega a ser menor que 0, se elimina el objeto.
	 */
	public void tick() {
		x += velX;
		y += velY;

		if(x<=initialX-120||initialX+120<=x) setVelX(getVelX()*-1);
		
		collision();
		
		if (health<0) {
			handler.removeObject(this);
		}
	}
	
	/* @Override
	 * parte visual del enemigos, se dibuja un rectangulo y se le da color
	 */
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x,(int) y, 16, 16);
		
	}

	/*
	 * Metodo que retorna el rectangulo o en otras palabras los bordes del objeto
	 * @return Rectangle 
	 */
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 16, 16);
	}
	
	/*
	 * Metodo que compara la posicion del enemigo con todos los objetos del
	 * juego y si este se interseca con un proyectil cambia de color y luego se 
	 * autodestruye. Se accede a la variable Score del HUD y se suman puntos
	 */
	private void collision() {
		for(int i = 0; i < handler.object.getLength(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID()==ID.Projectile){
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					health--;
					color = Color.ORANGE;
					hud.score(hud.getScore()+1);
				}
			}
		}
	}
}
