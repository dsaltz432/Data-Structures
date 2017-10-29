/*
 Daniel Saltz 

 The data structure takes the following form, where boxes are nodes that 
 contain a data item, and a reference to the next Node. The last Node in
 the list is a null element.
 
  _________         _________         _________		   ______
 | 	  |    |       | 	|    |       | 	  |    | 	  |		 |
 | 5  | ---|-----> | 3  | ---|-----> | 2  | ---|----> | null |
 |____|____|       |____|____|       |____|____|      |______|     
"firstNode"											  


Methods:
 	-isEmpty()
 	-insert()
 	-lookup()
 	-delete()
 	-printList()

 */

public class Stack<AnyType> implements StackInterface<AnyType> {
	private Node<AnyType> topNode;
	private int n = 0;
	
	// runtime is O(N)
	public void insert(AnyType x) {
		if (!lookup(x)) {
			Node<AnyType> newNode = new Node<AnyType>(x);
			newNode.next = topNode;
			topNode = newNode;	
			n++;
		}
	}

	public void delete(AnyType x) {
		Node<AnyType> current = new Node<AnyType>(null);
		Node<AnyType> previous = new Node<AnyType>(null);
		current = topNode;
		previous = topNode;
		if (lookup(x)) {
			while (current != null) {
				if (!current.data.equals(x)) {
					previous = current;
					current = current.next;
					n--;
				} else if (!current.data.equals(topNode.data)) {
					previous.next = current.next;
					return;
				} else {
					topNode = current.next;
					return;
				}
			}
		}
	}

	// runtime is O(N)
	public boolean lookup(AnyType x) {
		Node<AnyType> current = new Node<AnyType>(null);
		current = topNode;
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

	public void printStack() {
		Node<AnyType> current = new Node<AnyType>(null);
		current = topNode;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	@Override
	public void push(AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x);
		newNode.next = topNode;
		topNode = newNode;	
		n++;
	}

	@Override
	public AnyType pop() {
		if (topNode != null) {
			Node<AnyType> popped = topNode;
			topNode = topNode.next;
			n--;
			return popped.data;
		} else {
			return null;
		}
	}

	@Override
	public AnyType peek() {
		if (topNode != null) {
			return topNode.data;
		} else {
			return null;
		}
	}

}
