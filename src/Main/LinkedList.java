package Main;

public class LinkedList<T> extends List{

	private LinkedListNode<T> head = null;
	
	private int length = 0; 
	
	//Metodo que recibe un dato y añade un nodo con dicho dato en la cola de la lista
	public void addAsTail(T value) {
		if (this.length == 0) {
			this.head = new LinkedListNode<T>(value);
		} 
		else {
			LinkedListNode<T> temp = head; 
			while (temp.getNext()!=null) {
				temp= temp.getNext();
			}
			LinkedListNode<T> newTail = new LinkedListNode<T>(value);
			temp.setNext(newTail);
		}
		length++;
	}
	
	//Metodo que elimina el ultmimo nodo de la lista
	public void removeHead(){
		if(head.getNext()!=null)
			head = head.getNext();
		else head = null;
		length--;
	}
	
	//Metodo que elimina un nodo especifico, para ello recibe dicho dato
	public void removeThis(T object){
		LinkedListNode<T> temp = head;
		while (temp.getNext().getValue()!=object) {
			temp= temp.getNext();
		}
		if (temp.getNext().getNext()!=null){
			temp.setNext(temp.getNext().getNext());
		}
		else temp.setNext(null);
		length--;
	}

	//@return T Metodo que retorna el dato almacenado en el nodo especificado
	public T get(int i) {
		int position = 0;
		LinkedListNode<T> temp = head;
		
		while (position != i) {
			temp = temp.getNext();
			position++;
		}
		return temp.getValue();
	}
	
	//@return int metodo que retorna el largo de la lista
	public int getLength() {
		return length;
	}

	@Override
	public void tick() {
		
	}
}

class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;

	/*
	 * Constructor del nodo que recibe el valor de tipo T que guardará
	 */
	public LinkedListNode(T value) {
		this.value = value;
	}

	/*
	 * Metodo que define el marcador al siguiente nodo
	 */
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	/*Metodo que retorna el siguiente nodo 
	 * @return LinkedListNode
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/*
	 * @return T Metodo que retorna el dato almacenado en el nodo
	 */
	public T getValue() {
		return value;
	}
}