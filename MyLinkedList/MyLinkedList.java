package myImplementations;


public class MyLinkedList<T>{
	
	private Node<T> first;
	private int size;
	
	public MyLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public void add(T element) {
		Node<T> n = new Node<T>(element);
		if(this.first == null){
			this.first = n;
			this.size++;
			return;
		}
		Node<T> currentNode = this.first;
		for (int i = 0; i < getSize(); i++) {
			if (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			} else {
				currentNode.setNext(n);		
			}
		}
		size++;
	}
	
	public void add(T element, int position){
		if(position<0 || position>getSize()){
			System.out.println("Invalid number");
			return;
		}
		Node<T> currentNode = this.first;
		Node<T> newElement = new Node<T>(element);
		
		if(position==0){
			newElement.setNext(currentNode);
			this.first = newElement;
		}else{
			for(int i=0; i<position-1; i++){
				currentNode = currentNode.getNext();
			}
			newElement.setNext(currentNode.getNext());
			currentNode.setNext(newElement);
		}
		this.size++;
	}
	
	public void remove(int index){
		Node<T> currentNode = this.first;
		if(index<0 || index>=getSize()){
			return;
		}
		if(index == 0){
			this.first = currentNode.getNext();
			this.size--;
			return;
		}
		for(int i=0; i<index-1; i++){
			currentNode = currentNode.getNext();	
		}
		if(currentNode.getNext().getNext() == null){
			currentNode.setNext(null);
		}else{
			currentNode.setNext(currentNode.getNext().getNext());
		}
		this.size--;
	}

	public Node<T> get(int index){
		Node<T> currentNode = first;
		if(index<0 || index>=getSize()){
			System.out.println("Invalid number");
			return first;
		}
		for(int i=0; i<index; i++){
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	public int getSize(){
		return this.size;
	}

	public void print(){
		int size = this.size;
		Node<T> currentNode = this.first;
		System.out.print("[");
		while(size>0){
			if(size>1){
				System.out.print(currentNode + ", ");
			}else{
				System.out.print(currentNode);
			}
			currentNode = currentNode.getNext();
			size--;
		}
		System.out.println("]");
	}
	
}
