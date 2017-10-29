/*
 Daniel Saltz
 Doubly Linked List
 
 */

public class DoublyLinkedList<AnyType> implements DoublyLinkedListInterface<AnyType>{
	private Node<AnyType> head;
	private Node<AnyType> tail;
	private int n;

	public DoublyLinkedList(){
		head = new Node<AnyType>(null);
		tail = new Node<AnyType>(null);
		head.next = tail;
		tail.prev = head;
		n = 0;
	}

	public void insert(AnyType x) {
		if (!lookup(x)){
			Node<AnyType> newNode = new Node<AnyType>(x);
			newNode.next = head.next;
			newNode.prev = head;
			head.next.prev = newNode;
			head.next = newNode;
			n++;
		} else
			System.out.println("Item is already in list");
	}

	public void delete(AnyType x) {
		if (lookup(x)){
			Node<AnyType> curNode = new Node<AnyType>(null);
			Node<AnyType> prevNode = new Node<AnyType>(null);
			curNode = head.next;
			prevNode = head;

			while (curNode.next != null){
				if (curNode.data.equals(x)){
					curNode = curNode.next;
					prevNode.next = curNode;
					curNode.prev = prevNode;
				} else {
					curNode = curNode.next;
					prevNode = curNode.prev;
				}
			}
		} else
			System.out.println("The item is not in the list.");
	}

	public boolean lookup(AnyType x) {
		Node<AnyType> current = new Node<AnyType>(null);
		current = head.next;
		while (current != null){
			if(current.data != null && current.data.equals(x))
				return true;
			current = current.next;
		}
		return false;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

	//The runtime is O(N)
	public void printList() {
		Node<AnyType> current = new Node<AnyType>(null);
		current = head.next;
		while (current != tail){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	//The runtime is O(N)
	public void printListRev() {
		Node<AnyType> current = new Node<AnyType>(null);
		current = tail.prev;
		while (current != head){
			System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println();
	}
}
