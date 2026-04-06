package fibonacci;

public class FibonacciBasic {
    public static int getFibonacci(int n){
        if (n == 1 || n == 2) return 1;

        int a = getFibonacci(n - 1);
        int b = getFibonacci(n - 2);
        return a + b;
    }
}
