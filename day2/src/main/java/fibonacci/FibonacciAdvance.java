package fibonacci;

import java.util.Arrays;

public class FibonacciAdvance {
    public static int getFibonacci(int n){
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[1] = 1;
        arr[2] = 1;
        return f(n, arr);
    }

    private static int f(int n, int[] arr){
        if (arr[n] != -1){
            return arr[n];
        }

        int x = f(n - 1, arr);
        int y = f(n - 2, arr);
        arr[n] = x + y;
        return arr[n];
    }
}
