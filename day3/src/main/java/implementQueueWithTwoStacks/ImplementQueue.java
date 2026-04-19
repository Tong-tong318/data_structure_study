package implementQueueWithTwoStacks;

import stack.LinkedListStack;

public class ImplementQueue {
    LinkedListStack stack1 = new LinkedListStack();
    LinkedListStack stack2 = new LinkedListStack();

    public void push (int x){
        while (!stack1.isEmpty()){
            stack2.pull(stack1.pop());
        }
        stack1.pull(x);
        while (!stack2.isEmpty()){
            stack1.pull(stack2.pop());
        }
    }

    public int pop(){
        return (int) stack1.pop();
    }

    public int peek(){
        return (int) stack1.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
}
