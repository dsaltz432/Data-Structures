/*
 Daniel Saltz 

 The data structure takes the following form, where boxes are nodes that 
 contain a data item, and a reference to the next Node. The last Node in
 the list is a null element.
 
  _________         _________         _________		   ______
 | 	  |    |       | 	|    |       | 	  |    | 	  |		 |
 | 5  | ---|-----> | 3  | ---|-----> | 2  | ---|----> | null |
 |____|____|       |____|____|       |____|____|      |______|     
"firstNode"											   "head"


Interface: LinkedListInterface
Methods:
 	-isEmpty()
 	-insert()
 	-lookup()
 	-delete()
 	-printList()

 */

public class LinkedList<AnyType> implements LinkedListInterface<AnyType> {
	private Node<AnyType> firstNode;
	private int n = 0;
	
	// runtime is O(N)
	@Override
	public void insert(AnyType x) {
		if (!lookup(x)) {
			Node<AnyType> newNode = new Node<AnyType>(x);
			newNode.next = firstNode;
			firstNode = newNode;	
			n++;
		}
	}

	@Override
	public void delete(AnyType x) {
		Node<AnyType> current = new Node<AnyType>(null);
		Node<AnyType> previous = new Node<AnyType>(null);
		current = firstNode;
		previous = firstNode;
		if (lookup(x)) {
			while (current != null) {
				if (!current.data.equals(x)) {
					previous = current;
					current = current.next;
					n--;
				} else if (!current.data.equals(firstNode.data)) {
					previous.next = current.next;
					return;
				} else {
					firstNode = current.next;
					return;
				}
			}
		}
	}

	// runtime is O(N)
	@Override
	public boolean lookup(AnyType x) {
		Node<AnyType> current = new Node<AnyType>(null);
		current = firstNode;
		while (current != null) {
			if (current.data.equals(x))
				return true;
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	// runtime of O(N)
	@Override
	public void printList() {
		Node<AnyType> current = new Node<AnyType>(null);
		current = firstNode;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

}
