package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	//Constructor que recibe la lista de objetos del juego
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	/*Metodo que interpreta los comandos del teclado al ser presionado y los ejecuta,se controla la velocidad del jugador
	 * y se invoca el metodo de disparar de la clase juego
	 */
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.getLength(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for Player
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-4);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(4);
				if(key == KeyEvent.VK_SPACE) Game.shoot();
					
			}
			
		}
	}
	
	/*Metodo que interpreta los comandos del teclado al ser soltado y los ejecuta,se controla la velocidad del jugador
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.getLength(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {

				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			}
		}
	}
}
