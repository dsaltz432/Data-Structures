/*
 Daniel Saltz
 
 This is the test class. I create a linked list, and then add and delete
 several Integers to test each of its methods.
 
 */

public class TestLinkedList<AnyType> {

	public static void main(String[] args) {
		System.out.println("Testing Linked List");
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// testing isEmpty()
		System.out.println("\nCreated the list. Is it empty? " + list.isEmpty());
		
		// testing insert()
		System.out.println("\nInserted 1, 3, 2, 5 into the list");
		list.insert(1);
		list.insert(3);
		list.insert(2);
		list.insert(5);
		System.out.println("Is the list it empty? " + list.isEmpty());
		
		// testing printList()
		System.out.println("\nPrinting the list:");
		list.printList();
		
		//testing lookup()
		System.out.println("Is 2 in the list? "+list.lookup(1));
		System.out.println("Is 5 in the list? "+list.lookup(5));
		System.out.println("Is 4 in the list? "+list.lookup(4));

		// testing modified insert() that prevent adding duplicate items
		list.insert(2);
		System.out.println("\nInserted 2 again. Printing the list:");
		list.printList();
	
		// testing delete()
		list.delete(1);
		System.out.println("Deleted 1, here's the new list:");
		list.printList();
		list.delete(2);
		System.out.println("Deleted 2, here's the new list:");
		list.printList();
		list.delete(5);
		System.out.println("Deleted 5, here's the new list:");
		list.printList();
		list.delete(3);
		System.out.println("Deleted 3, is the list empty? "+list.isEmpty());
	}
}
