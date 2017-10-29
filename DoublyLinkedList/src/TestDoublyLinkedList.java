/*
 Daniel Saltz
 Doubly Linked List
 
 */

public class TestDoublyLinkedList {

	public static void main(String[] args){
		
		System.out.println("Testing Double LinkedList\n");
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
		//tests empty()
		System.out.println("Is it empty? " + list.isEmpty());
		
		//adds items
		list.insert(new Integer(8));
		list.insert(new Integer(5));
		list.insert(new Integer(12));
		list.insert(new Integer(4));
		list.insert(new Integer(1));
		
		//prints the list forwards and backwards
		System.out.println("\nPrinting the list forwards and backwards");
		list.printList();
		list.printListRev();
		
		//tests lookup()
		System.out.println("\nIs the list empty? " + list.isEmpty());
		System.out.println("Is 16 in the list? " + list.lookup(16));
		System.out.println("Is 5 in the list? " + list.lookup(5));
		
		//delete method
		System.out.println("\nDelete 4 and reprint");
		list.delete(4);
		list.printList();
		list.printListRev();
		
		System.out.println("\nDelete 1 and reprint");
		list.delete(1);
		list.printList();
		list.printListRev();
		
		System.out.println("\nDelete 8 and reprint");
		list.delete(8);
		list.printList();
		list.printListRev();
		
		
	}
}