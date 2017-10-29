/*
 Daniel Saltz
 
 This is the test class. I create a stack, and then push and pop elements onto
 and off of the stack to test each of the class methods.
 
 */

public class TestStack<AnyType> {

	public static void main(String[] args) {
		System.out.println("Testing a Stack");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// testing isEmpty()
		System.out.println("\nCreated the stack. Is it empty? " + stack.isEmpty());
		
		// testing push()
		System.out.println("\nPushed 1, 3, 2, 5 onto the stack");
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		System.out.println("Is the stack it empty? " + stack.isEmpty());
		
		// testing printStack()
		System.out.println("\nPrinting the stack:");
		stack.printStack();
		
		// testing pop() and peek()
		int popped1 = stack.pop();
		System.out.println("\nPopped the top element, here's the new stack:");
		stack.printStack();
		System.out.println("Which element was popped? " + popped1);
		int popped2 = stack.pop();
		System.out.println("Popped the top element, here's the new stack:");
		stack.printStack();
		System.out.println("Which element was popped? " + popped2);
		System.out.println("Popped the top element, here's the new stack:");
		stack.pop();
		stack.printStack();
		System.out.println("Which is on the top? " + stack.peek());
		stack.pop();
		System.out.println("Popped the last element. Is the stack empty? " + stack.isEmpty());
	}
}
