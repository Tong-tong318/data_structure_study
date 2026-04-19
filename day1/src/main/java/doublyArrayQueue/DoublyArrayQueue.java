package doublyArrayQueue;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 记住，head放数据，tail不放
 * @param <E>
 */
public class DoublyArrayQueue<E> implements Iterable<E> {
    private int size = 0;
    private int capacity;
    private E[] array;
    private int head = 0;
    private int tail = 0;

    public DoublyArrayQueue(){
        new DoublyArrayQueue<E>(1024);
    }

    public DoublyArrayQueue(int capacity){
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    public boolean offerLast(E value){
        if (isFull()) return false;

        array[tail] = value;
        tail = inc(tail, capacity);
        size++;
        return true;
    }

    public boolean offerFirst(E value){
        if (isFull()) return false;

        head = dec(head, capacity);
        array[head] = value;
        size++;
        return true;
    }

    public E pullLast(){
        if (isEmpty()) return null;

        tail = dec(tail, capacity);
        E value = array[tail];
        array[tail] = null; //垃圾回收
        size--;
        return value;
    }

    public E pullFirst(){
        if (isEmpty()) return null;

        E value = array[head];
        array[head] = null; //垃圾回收
        head = inc(head, capacity);
        size--;
        return value;
    }

    public E peekFirst(){
        if (isEmpty()) return null;

        return array[head];
    }

    public E peekLast(){
        if (isEmpty()) return null;

        return array[dec(tail, capacity)];
    }

    public boolean isFull(){
        return inc(tail, capacity) == head;
    }

    public boolean isEmpty(){
        return tail == head;
    }

    public void ForEach(Consumer<E> consumer){
        int myhead = head;
        for (int i = 0; i < size; i++) {
            consumer.accept(array[myhead]);
            myhead = inc(myhead, capacity);
        }
    }



    private int inc(int i, int length){
        if (i + 1 > length - 1){
            return 0;
        }
        return i + 1;
    }

    private int dec(int i, int length){
        if (i - 1 < 0){
            return length - 1;
        }
        return i - 1;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int myhead = head;
            @Override
            public boolean hasNext() {
                return myhead != tail;
            }

            @Override
            public E next() {
                E e = array[myhead];
                myhead = inc(myhead, capacity);
                return e;
            }
        };
    }
}
