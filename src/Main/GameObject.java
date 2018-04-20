package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
 
	protected double y, x;
	protected ID id;
	protected double velX, velY;
	
	public GameObject(double x, double y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//Metodos que unicamente son heredados a las clases hijas, estos las definen.
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();
	
	//Metodo para alterar la posicion en Y del objeto
	public void setX(double x) {
		this.x = x;		
	}
	
	//Metodo para alterar la posicion en Y del objeto
	public void setY(double y) {
		this.y = y;	
	}
	
	//@return double posición en X del objeto en la ventana
	public double getX(){
		return x;
	}
	
	//@return double posición en Y del objeto en la ventana
	public double getY() {
		return y;		
	}
	
	//@return ID devuelve la id del objeto
	public ID getID() {
		return id;
	}
	
	//Metodo para alterar la razon por la que cambia la posicion en X
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	//Metodo para alterar la razon por la que cambia la posicion en Y
	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	//@return double devuelve la velocidad del objeto en X
	public double getVelX() {
		return velX;
	}
	
	//@return double devuelve la velocidad del objeto en Y
	public double getVelY() {
		return velY;
	} 
}
 