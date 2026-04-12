package stack;

import linkedList.LinkedList;

public class LinkedListStack implements StackInterface{
    LinkedList list = new LinkedList();
    int capacity;
    int size = 0;

    public LinkedListStack(){
        capacity = 1024;
    }
    public LinkedListStack(int capacity){
        this.capacity = capacity;
    }


    @Override
    public boolean pull(Object value) {
        if (isFull()) return false;
        list.add(value, 0);
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;
        size--;
        return list.delete(0);
    }

    @Override
    public Object peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
