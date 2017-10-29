public class Node<AnyType> {
	public AnyType data;
	public Node<AnyType> next;
	public Node<AnyType> prev;
	
	public Node(AnyType x) {
		data = x;
	}
}