package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BossEnemy extends GameObject{
	
	private int health = 40;
	private Handler handler;
	private Color color = Color.RED;
	private final double initialX = (int)x;
	private HUD hud;
	private List<GameObject> row;

	public BossEnemy(double x, double y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.row = row;
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

	/*@Override
	* parte visual del enemigo, se dibuja un rectangulo y se le da color
	*/
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x,(int) y, 20, 20);
		
	}

	/*
	 * @Override Metodo que retorna el rectangulo o en otras palabras los bordes del objeto
	 * @return Rectangle 
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 20, 20);
	}
	
	/*
	 * Metodo que compara la posicion del enemigo con todos los objetos del
	 * juego y si este se interseca con un proyectil cambia de color y luego se 
	 * autodestruye.
	 */
	private void collision() {
		for(int i = 0; i < handler.object.getLength(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID()==ID.Projectile){
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					health--;
					Game.killBoss();
				}
			}
		}
	}
}
