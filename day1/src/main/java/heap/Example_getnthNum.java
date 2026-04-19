package heap;

public class Example_getnthNum {
    public static void main(String[] args) {
        System.out.println(getnth(2,new int[]{22,43,67,99,988}));
        System.out.println(getnth(2,new int[]{46,29,444,54,25,89,90}));


    }


    public static int getnth(int n, int[] arr){
        MinHeap heap = new MinHeap();
        for (int value : arr){
            if(heap.getSize() < n){
                heap.offer(value);
            } else if (heap.peek() < value){
                heap.replace(value);
            }
        }
        return heap.peek();
    }

}
