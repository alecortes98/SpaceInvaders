package Main;

public class DoubleLinkedList<T> extends List{
private DoubleLinkedListNode<T> head = null;
	
	private int length = 0; 
	
	//Metodo que recibe un dato y añade un nodo con dicho dato en la cola de la lista
	public void addAsTail(T value) {
		if (this.length == 0) {
			this.head = new DoubleLinkedListNode<T>(value);
		} 
		else {
			DoubleLinkedListNode<T> temp = head; 
			while (temp.getNext()!=null) {
				temp= temp.getNext();
			}
			DoubleLinkedListNode<T> newTail = new DoubleLinkedListNode<T>(value);
			temp.setNext(newTail);
			newTail.setPrevious(temp);
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
	public void removeThis(T object) {
		DoubleLinkedListNode<T> temp = head; 
		while (temp.getNext().getValue()!=object) {
			temp= temp.getNext();
		}
		if (temp.getNext().getNext()!=null){
			temp.setNext(temp.getNext().getNext());
			temp.getNext().setPrevious(temp);
		}
		else temp.setNext(null);
		length--;
	}

	//@return T Metodo que retorna el dato almacenado en el nodo especificado
	public T get(int i) {
		int position = 0;
		DoubleLinkedListNode<T> temp = head;
		
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

	
	public void tick() {
		
		
	}
}

class DoubleLinkedListNode<T> {
	private T value;
	private DoubleLinkedListNode<T> next;
	private DoubleLinkedListNode<T> previous;

	/*
	 * Constructor del nodo que recibe el valor de tipo T que guardará
	 */
	public DoubleLinkedListNode(T value) {
		this.value = value;
	}

	/*
	 * Metodo que define el marcador al siguiente nodo
	 */
	public void setNext(DoubleLinkedListNode<T> next) {
		this.next = next;
	}

	/*Metodo que retorna el siguiente nodo 
	 * @return LinkedListNode
	 */
	public DoubleLinkedListNode<T> getNext() {
		return next;
	}
	/*Metodo que retorna el anterior nodo 
	 * @return DoubleLinkedListNode
	 */
	public DoubleLinkedListNode<T> getPrevious() {
		return previous;
	}
	
	/*
	 * Metodo que define el marcador al anterior nodo
	 */
	public void setPrevious(DoubleLinkedListNode<T> previous) {
		this.previous = previous;
	}

	/*
	 * @return T Metodo que retorna el dato almacenado en el nodo
	 */
	public T getValue() {
		return value;
	}
}

