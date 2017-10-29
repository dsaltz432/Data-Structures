public interface StackInterface<AnyType> {
	public boolean isEmpty();
    public void push(AnyType x);
    public AnyType pop();
    public AnyType peek();
}
