package queue;

import java.util.function.Consumer;
/**
 *   循环队列
 *   基于 数组 实现
 */
public class ArrayQueue implements QueueInterface{

    private int head = 0;
    private int tail = 0;
    int capacity = 10;
    private Object[] arr;

    public ArrayQueue(int capacity){
        arr = new Object[capacity+1];
        this.capacity = capacity;
    }
    public ArrayQueue(){
        arr = new Object[11];
    }


    @Override
    public Boolean offer(Object o) {
        if (isFull()){
            return false;
        }

        arr[tail] = o;
        tail = (tail + 1) % (capacity+1);
        return true;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[head];
    }

    @Override
    public Object pull() {
        if (isEmpty()) {
            return null;
        }

        Object value = arr[head];
        head = (head+1) % (capacity+1);
        return value;
    }

    @Override
    public Boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Boolean isFull() {
        return (tail + 1) % (capacity+1) == head;
    }

    public void forEach(Consumer<Object> consumer){
        int myhead = head;
        int mytail = tail;
        while (myhead != mytail){
            consumer.accept(arr[myhead]);
            myhead = (myhead + 1) % (capacity+1);
        }
    }
}
