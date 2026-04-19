package queue;

import entity.Priority;
import entity.PriorityNode;

public class PriorityQueue<E extends Priority<?>> implements QueueInterface<E>{

    int len = 0;
    int capacity;
    E[] arr;
    public PriorityQueue(int capacity){
        this.capacity = capacity;
        arr = (E[]) new PriorityNode<?>[capacity];
    }
    public PriorityQueue(){
        this.capacity = 1024;
        arr = (E[]) new Priority[capacity];
    }

    @Override
    public Boolean offer(E value) {
        if (isFull()) return false;

        arr[len] = value;
        up(arr, len);
        len++;
        return true;
    }

    @Override
    public E peek() {
        return arr[0];
    }

    @Override
    public E pull() {
        E value = arr[0];
        len--;
        arr[0] = arr[len];
        arr[len] = null;
        down(arr);
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

    private void up(E[] arr, int target){
        int parent = (target - 1) / 2;
        E value = arr[target];
        while (target != 0 && arr[parent].getPriority() < arr[target].getPriority()){
            arr[target] = arr[parent];
            target = parent;
            parent = (target - 1) / 2;
        }
        arr[target] = value;
    }

    private void down(E[] arr){
        int position = 0;
        E value = arr[position];
        while (2*position + 1 < len) {
           E max = arr[position];
           int maxi = position;
           if (arr[2*position+1].getPriority() > max.getPriority()){
               maxi = 2 * position + 1;
               max = arr[maxi];
           }
           if (2*position+2 < len && arr[2*position+2].getPriority() > max.getPriority()){
               maxi = 2 * position + 2;
               max = arr[maxi];
           }
           arr[position] = arr[maxi];
           position = maxi;
        }
        arr[position] = value;
    }
}
