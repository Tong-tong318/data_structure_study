package dynamicArray;

import java.util.Iterator;
import java.util.function.Consumer;

public class DynamicArray implements Iterable<Integer>{
    private int capacity = 10;
    private int[] arr = new int[capacity];
    private int size = 0;

    public void add(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        checkFullAndExpand();
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    public void addLast(int value) {
        checkFullAndExpand();
        arr[size] = value;
        size++;
    }

    public int get(int index) {
        return arr[index];
    }

    public void remove(int index) {
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }

    public void update(int index, int value) {
        arr[index] = value;
    }

    public void ForEach(Consumer<Integer>  consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }










    private void checkFullAndExpand() {
        if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public Integer next() {
                return arr[index++];
            }
        };
    }
}
