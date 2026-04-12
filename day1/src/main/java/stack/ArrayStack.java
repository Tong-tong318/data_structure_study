package stack;

public class ArrayStack implements StackInterface{
    Object[] arr;
    int capacity = 1024;
    int size = 0;

    public ArrayStack(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity - 1];
    }
    public ArrayStack(){
        arr = new Object[capacity - 1];
    }


    @Override
    public boolean pull(Object value) {
        if (isFull()) return false;

        arr[size] = value;
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;

        size--;
        return arr[size];
    }

    @Override
    public Object peek() {
        if (isEmpty()) return null;

        return arr[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
