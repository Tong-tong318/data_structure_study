package heap;

public class Example_findMid {
    private MaxHeap maxHeap;
    private  MinHeap minHeap;

    public Example_findMid(){
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
    }

    public void add(int value){
        if (maxHeap.getSize() == minHeap.getSize()){
            minHeap.offer(value);
            maxHeap.offer(minHeap.pull());
        }else {
            maxHeap.offer(value);
            minHeap.offer(maxHeap.pull());
        }
    }

    public double getMid(){
        if (maxHeap.getSize() == minHeap.getSize()){
            return (maxHeap.peek()+minHeap.peek()) >>> 1;
        }else {
            return maxHeap.peek();
        }
    }
}
