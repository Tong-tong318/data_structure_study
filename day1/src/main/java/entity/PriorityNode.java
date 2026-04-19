package entity;

public class PriorityNode<E> implements Priority<E>{
    private E value;
    private int priority;

    public PriorityNode(E value, int priority){
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public E getValue() {
        return this.value;
    }
}
