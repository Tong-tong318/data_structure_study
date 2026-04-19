package implementStackWithQueue;

import queue.LinkedQueue;

public class ImplementStack {
    private LinkedQueue queue = new LinkedQueue();
    private int size = 0;

    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.pull());
        }
        size++;
    }

    public int pop(){
        size--;
        return (int) queue.pull();
    }

    public int top(){
        return (int) queue.peek();
    }

    public boolean empty(){
        return size == 0;
    }
}
