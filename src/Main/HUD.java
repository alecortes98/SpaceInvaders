package Main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private int timer = 600;
	private int score = 0;
	private int level = 0;
	private int waveCounter = 0;
	
	/*
	 * En meste metodo tick se modifica la variable timer y si esta llega a 0 se reinicia a su valor original.
	 * cada vez que el timer llegue a 0 (se debera desplegar una hilera de enemigos, por lo que ) la variable
	 * de contador de hileras de enemigos waveCounter es aumentada, y con ella respectivamente el nivel.
	 */
	public void tick() {
		timer = Game.clamp(timer, 0, 600);
		timer--;
		if (timer<=0) {
			timer = 600;
			waveCounter++;
		if (waveCounter==1) level=1;
		
		if (waveCounter==2) level=2;
		 
		if (waveCounter==4) level=3;
		 
		if (waveCounter==6) level=4;
		}
		if (waveCounter==9) level=5;
		
		if (waveCounter==12) {
			//win
		}
		
	}
	
	/*
	 * se renderizan detalles de la interfaz grafica como el Score, Level, Wave actual
	 * y el tiempo que falta para que la siguiente aparezca
	 */
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Time Until Next Wave: ", 10, 20);
		g.setColor(Color.green);
		g.fillRect(12, 25, timer/3, 16);
		g.setColor(Color.white);
		g.drawRect(12, 25, 200, 16);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 10, 60);
		g.drawString("Level:  " + level, 10, 75);
		g.drawString("Wave:  " + waveCounter, 10, 90); 
		g.setColor(new Color(10,100,40));
		g.fillRect(0, Game.HEIGHT-68, Game.WIDTH, 68);
		
	}
	
	/*
	 * setter del atributo score
	 */
	public void score(int score) {
		this.score = score;
	}
	
	/*
	 * getter del atributo score
	 * @return int del puntaje
	 */
	public int getScore() {
		return score;
	}
	
	/*
	 * getter del atributo Level
	 * @return int del nivel
	 */
	public int getLevel() {
		return level;
	}
	
	/*
	 * setter del atributo Level
	 */
	public void setLevel(int level) {

		this.level = level;
	}

	/*
	 * getter del atributo Timer
	 * @return int del timer
	 */
	public int getTimer() {
		return timer;
	}
}
