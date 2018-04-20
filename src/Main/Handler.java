package Main;

import java.awt.Graphics;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	/*
	 * Se recorre la lista de objetos del juego y en cada uno se utiliza su metodo tick()
	 */
	public void tick() {
		for(int i = 0; i < object.getLength(); i++) {
			GameObject tempObject = object.get(i); 
			
			tempObject.tick();
		}
	}
	
	
	public void render(Graphics g) {
		for(int i = 0; i < object.getLength(); i++) {
			GameObject tempObject = object.get(i); 
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.addAsTail(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.removeThis(object);
	}
}
