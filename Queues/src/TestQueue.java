/*
 Daniel Saltz
  
 */

public class TestQueue {

	public static void main(String[] args) {
		
		System.out.println("Testing the Queue class");
		
		Queue<Integer> queue = new Queue<Integer>();
		
		// test isEmpty()
		System.out.println("\nIs the queue empty? " + queue.isEmpty());
	
		// testing enqueue()
		System.out.println("Enqueueing several elements");
		queue.enqueue(1);
		queue.enqueue(9);
		queue.enqueue(5);
		queue.enqueue(22);
		queue.enqueue(102);
		System.out.print("Here's the printed queue: ");
		queue.printQueue();
		System.out.println("Is the queue empty? " + queue.isEmpty());

		// testing dequeue() and peek()
		int dequeued = queue.dequeue();
		System.out.println("\nDequeued the last element. Which element was dequeued? " + dequeued);
		System.out.print("Here's the printed queue: ");
		queue.printQueue();

		queue.dequeue();
		System.out.print("\nDequeued again. Here's the printed queue: ");
		queue.printQueue();
		System.out.println("What's the last element now? " + queue.peek());
	
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("Dequeued 3 more times. Is the queue empty? " + queue.isEmpty());
	}
}
