package heap;

import org.junit.Test;

public class TestHeap {
    @Test
    public void Test1(){
        MaxHeap heap = new MaxHeap();
        heap.heaplify(new int[]{11, 33, 2, 34, 458, 37, 45,2244,555,1,56});
        int layer = 1;
        int count = 0;
        for (int value : heap){
            System.out.print(value + " ");
            count++;
            if (count == layer){
                System.out.println();
                count = 0;
                layer = layer << 1;
            }
        }
    }
}
