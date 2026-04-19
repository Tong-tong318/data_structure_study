package queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockedQueue<E> {
    private E[] array;
    int head;
    int tail;
    int capacity;
    AtomicInteger size = new AtomicInteger(0);
    ReentrantLock headLock = new ReentrantLock();
    Condition headwait = headLock.newCondition();

    ReentrantLock tailLock = new ReentrantLock();
    Condition tailwait = tailLock.newCondition();

    public LockedQueue(int capacity){
        this.capacity = capacity;
        array = (E[]) new Object[capacity + 1];
    }

    public LockedQueue(){
        this(1024);
    }

    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        int s;
        try {
            while (isFull()){
                tailwait.await();
            }
            array[tail] = e;
            tail = increase(tail, capacity);
            s = size.getAndIncrement();
            if (s+1 < capacity){
                tailwait.signal();
            }
        } finally {
            tailLock.unlock();
        }

        if (s == 0) {
            headLock.lock();
            try {
                headwait.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    public E pull() throws InterruptedException {
        headLock.lockInterruptibly();
        int s;
        E value;
        try {
            while (isEmpty()){
                headwait.await();
            }
            value = array[head];
            array[head] = null;
            head = increase(head, capacity);
            s = size.getAndDecrement();
            if (s > 1){
                headwait.signal();
            }
        }finally {
            headLock.unlock();
        }

        if (s == capacity){
            tailLock.lock();
            try {
                tailwait.signal();
            }finally {
                tailLock.unlock();
            }
        }
        return value;
    }

    public boolean isEmpty(){
        return size.get() == 0;
    }

    public boolean isFull(){
        return size.get() == capacity;
    }

    private int increase(int target, int capacity){
        if (target == capacity) target = -1;
        return ++target;
    }

    private int decrease(int target, int capacity){
        if (target == 0) target = capacity + 1;
        return --target;
    }
}
