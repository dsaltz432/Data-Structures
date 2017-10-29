/*
 Daniel Saltz
 
 This is my doubly linked list implementation of a queue
 */

public class Queue<AnyType> implements QueueInterface<AnyType> {
	private Node<AnyType> head;
	private Node<AnyType> tail;
	private int n;
	
	public Queue() {
		n = 0;
		head = new Node<AnyType>(null);
		tail = new Node<AnyType>(null);
		head.next = tail;
		tail.prev = head;
	}
	
	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void enqueue(AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x);
		newNode.next = head.next;
		newNode.prev = head;
		head.next.prev = newNode;
		head.next = newNode;
		n++;
	}

	@Override
	public AnyType dequeue() {
		if (!isEmpty()) {
			Node<AnyType> lastNode = tail.prev;
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			n--;
			return lastNode.data;
		}
		return null;
	}

	@Override
	public AnyType peek() {
		if (!isEmpty()) {
			return tail.prev.data;
		}
		return null;
	}

	public void printQueue() {
		Node<AnyType> current = head.next;
		while (current != tail) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
