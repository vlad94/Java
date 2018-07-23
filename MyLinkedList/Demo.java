package myImplementations;


public class Demo {

	public static void main(String[] args) {
		
		MyLinkedList p = new MyLinkedList<>();
		p.add(5);
		p.add(18);
		p.print();
		p.add(-230);
		p.add(0);
		p.add(18);
		p.print();
		System.out.println();
		p.add(2222,5);
		p.add(3333,5);
		p.print();
		System.out.println();
		p.remove(2);
		p.remove(3);
		p.print();
		System.out.println(p.getSize());
		
		
	}

}
