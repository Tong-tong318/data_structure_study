package queue;

import entity.Priority;

public class PriorityQueue1<E extends Priority<?>> implements QueueInterface<E>{
    int capacity;
    int len = 0;
    E[] arr;

    @SuppressWarnings("unchecked")
    public PriorityQueue1(int capacity){
        this.capacity = capacity;
        this.arr = (E[]) new Priority[capacity];
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue1(){
        this.capacity = 1024;
        this.arr = (E[]) new Priority[capacity];
    }




    @Override
    public Boolean offer(E e) {
        if (isFull()) return false;
        int count = len;
        while (count != 0 && e.getPriority() < arr[count - 1].getPriority()) {
            count--;
            if (count == 0) break;
        }
        System.arraycopy(arr, count, arr, count + 1, len - count);
        arr[count] = e;
        len++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;

        return arr[len-1];
    }

    @Override
    public E pull() {
        if (isEmpty()) return null;

        E value = arr[len-1];
        arr[--len] = null;
        return value;
    }

    @Override
    public Boolean isEmpty() {
        return len == 0;
    }

    @Override
    public Boolean isFull() {
        return len == capacity;
    }
}
