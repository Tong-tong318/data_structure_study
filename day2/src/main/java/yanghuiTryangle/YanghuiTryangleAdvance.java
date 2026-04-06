package yanghuiTryangle;

public class YanghuiTryangleAdvance {
    static int[][] arr;
    public static void print2(int n){
        arr = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            arr[i] = new int[i+1];
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", getElement2(i, j));
            }
            System.out.println();
        }
    }


    private static int getElement2(int a, int b){
        if (b == 1 || a == b) return 1;

        if (arr[a][b] != 0) return arr[a][b];

        int x = getElement2(a-1, b) + getElement2(a-1, b-1);
        arr[a][b] = x;
        return x;
    }
}
