package heap;

import java.util.Iterator;

public class MinHeap implements Iterable<Integer> {
    private int[] arr;
    private final int capacity;
    private int size;

    public MinHeap(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }
    public MinHeap(){
        this(1024);
    }

    public void heaplify(int[] arr){
        this.arr = arr;
        size = arr.length;
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            down(i);
        }
    }
    public void offerArray(int[] arr1){
        for (int j : arr1) {
            offer(j);
        }
    }

    public boolean offer(int a){
        if (size == capacity) {
            return false;
        }
        arr[size] = a;
        up(size);
        size++;
        return true;
    }
    public int pull(){
        if (size == 0) return -1;
        int value = arr[0];
        arr[0] = arr[size - 1];
        size--;
        down(0);
        return value;
    }

    public int peek(){
        if (size == 0) return -1;

        return arr[0];
    }

    public int replace(int value){
        int got = arr[0];
        arr[0] = value;
        down(0);
        return got;
    }

    private void down(int target){
        int left = target*2 + 1;
        int right = left + 1;
        int min = target;
        if (size > left && arr[left] < arr[min]){
            min = left;
        }
        if (size > right && arr[right] < arr[min]){
            min = right;
        }

        if (min != target){
            swip(min, target);
            down(min);
        }
    }

    private void up(int child){
        if (child == 0) return;

        int parent = child - 1 >>> 1;
        int value = arr[child];
        if (arr[child] < arr[parent]){
            arr[child] = arr[parent];
            child = parent;
            up(child);
        }
        arr[child] = value;
    }

    private void swip(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int count;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Integer next() {
                int value = arr[count];
                count++;
                return value;
            }
        };
    }

    public int getSize() {
        return size;
    }
}
