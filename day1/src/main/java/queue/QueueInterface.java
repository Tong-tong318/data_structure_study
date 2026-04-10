package queue;

public interface QueueInterface<E> {
    public Boolean offer(E e);
    public E peek();
    public E pull();
    public Boolean isEmpty();
    public Boolean isFull();

}
