package bubbleSort;

import org.junit.Test;

import java.util.Arrays;


public class TestBubbleSort {
    @Test
    public void Test01() {
        int[] arr = {12, 43, 55, 632, 35, 3, 557, 777, 437, 7, 2};
        BubbleSort bubbleSort = new BubbleSort();
        int[] sorted = bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
