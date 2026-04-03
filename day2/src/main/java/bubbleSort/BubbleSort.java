package bubbleSort;

public class BubbleSort {

    public int[] bubbleSort(int[] arr){
        return singleBubbleSort(arr, arr.length - 1);
    }




    private int[] singleBubbleSort(int[] arr, int a){
        if (a == 0){
            return arr;
        }

        for (int i = 0; i < a; i++) {
            if (arr[i] > arr[a]){
                int temp = arr[i];
                arr[i] = arr[a];
                arr[a] = temp;
            }
        }

        return singleBubbleSort(arr, a-1);
    }
}
