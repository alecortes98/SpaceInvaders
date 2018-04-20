package Main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private static int timer = 600;
	private ListHandler listHandler;
	
	/*
	 * Constructor de la clase Spawn que recibe el hud y el handler
	 */
	public Spawn(Handler handler, HUD hud, ListHandler listHandler) {
		this.handler = handler;
		this.hud = hud;
		this.listHandler = listHandler;
		
	}
	
	/*
	 * En este metodo tick se modifica el timer y cada vez que este llega a cero se 
	 * implementa una nueva hilera de enemigos.
	 */
	public void tick() {
		timer--;
		
		if (timer==0) {
			timer=600;
			if(hud.getLevel()==1) spawnRow(1);
			if(hud.getLevel()==2) spawnRow(2);
			if(hud.getLevel()==3) spawnRow(3);
			if(hud.getLevel()==4) spawnRow(4);
			if(hud.getLevel()==5) spawnRow(5);
		}
	}
	
	/*
	 * El metodo spawnRow crea una lista enlazada con 5 objetos enemigos
	 * y define su velocidad según el nivel en el que este el juego
	 */
	public void spawnRow(int level) {
		int randomNumber = r.nextInt(2);
		
		EnemyRow enemyRow = new EnemyRow(randomNumber, hud, handler);
		
		enemyRow.spawnRow();

		if(level == 1)
			for(int i = 0; i < 5; i++) {
				handler.addObject(enemyRow.get(i));
				enemyRow.get(i).setVelY(0.25);
				enemyRow.get(i).setVelX(1.0);
			}
		if(level == 2)
			for(int i = 0; i < 5; i++) {
				handler.addObject(enemyRow.get(i));
				enemyRow.get(i).setVelY(0.5);
				enemyRow.get(i).setVelX(1.0);
			}
		if(level == 3)
			for(int i = 0; i < 5; i++) {
				handler.addObject(enemyRow.get(i));
				enemyRow.get(i).setVelY(0.75);
				enemyRow.get(i).setVelX(1.0);
			}
		if(level == 4)
			for(int i = 0; i < 5; i++) {
				handler.addObject(enemyRow.get(i));
				enemyRow.get(i).setVelY(1.0);
				enemyRow.get(i).setVelX(1.0);
			}
		if(level == 5)
			for(int i = 0; i < 5; i++) {
				handler.addObject(enemyRow.get(i));
				enemyRow.get(i).setVelY(1.25);
				enemyRow.get(i).setVelX(1.0);
			}
	}
}
