package Main;

public abstract class List<T> {
	
	private int length;
	
	public abstract T get(int i);
	
	public abstract void tick();
	
	public int getLength() {
		return length;
	}
}
