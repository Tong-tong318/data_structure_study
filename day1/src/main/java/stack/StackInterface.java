package stack;

public interface StackInterface {
    public boolean pull(Object value);
    public Object pop();
    public Object peek();
    public boolean isEmpty();
    public boolean isFull();
}
