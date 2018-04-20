package Main;

public class ListHandler {
	
	LinkedList<List> list = new LinkedList<List>();
	
	/*
	 * Se recorre la lista de listas del juego y en cada uno se utiliza su metodo tick()
	 */
	public void tick() {
		for(int i = 0; i < list.getLength(); i++) {
			List tempList = list.get(i); 
			
			tempList.tick();
		}
	}
	
	public void addObject(List list) {
		this.list.addAsTail(list);
	}
	
	public void removeObject(List list) {
		this.list.removeThis(list);
	}
}
