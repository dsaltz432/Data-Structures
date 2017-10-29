public class Node<AnyType> {
	public AnyType data;
	public Node<AnyType> next;
	
	public Node(AnyType data) {
		this.data = data;
	}
}
