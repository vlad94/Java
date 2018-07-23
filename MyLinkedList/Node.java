package myImplementations;

public class Node<T> {

	private Node<T> next;
	private T element;
	
	public Node(T element){
		this.element = element;
		this.next = null;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	@Override
	public String toString() {
		return "" + this.element;
	}
}
