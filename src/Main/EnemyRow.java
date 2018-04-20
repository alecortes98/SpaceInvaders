package Main;

import java.util.Random;

public class EnemyRow {
	
	private int type;
	private HUD hud;
	private Handler handler;
	private List<GameObject> enemyRow;
	private Random r = new Random();
	
	//private int x1,x2,x3,x4,x5; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11uno
	
	public EnemyRow(int type, HUD hud, Handler handler) {
		this.type = type;
		this.handler = handler;
		this.hud = hud;
	}
	
	@SuppressWarnings("unchecked")
	public void spawnRow() {
		if(type==0) {
			enemyRow = new LinkedList<GameObject>();
			for(int i = 0, x = 150; i < 5 & x <=550 ; i++, x+=100) {
				((LinkedList<GameObject>) enemyRow).addAsTail(new BasicEnemy(x, -20, ID.Enemy, handler, hud));
			}
		}
		if(type==1) {
			enemyRow = new DoubleLinkedList<GameObject>();
			boolean boss = true;
			int randomNumber = r.nextInt(5);
			for(int i = 0, x = 150; i < 5 & x <=550 ; i++, x+=100) {
				if(boss && randomNumber==i) {
					((DoubleLinkedList<GameObject>) enemyRow).addAsTail(new BossEnemy(x, -20, ID.Enemy, handler, hud));
					boss=false;
				}
				else ((DoubleLinkedList<GameObject>) enemyRow).addAsTail(new BasicEnemy(x, -20, ID.Enemy, handler, hud));
			}	
		}
		if(type==2) {
			enemyRow = new DoubleLinkedList<GameObject>();
		}
		
	}
	public void tick() {
		

	}
	public GameObject get(int i) {
		return (GameObject) enemyRow.get(i);
	}
	
}
