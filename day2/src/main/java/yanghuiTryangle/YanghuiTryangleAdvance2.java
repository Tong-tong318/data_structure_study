package yanghuiTryangle;

import java.util.Arrays;

public class YanghuiTryangleAdvance2 {
    static int[] up;
    static int[] down;
    public static void print3(int n){
        up = new int[n+1];
        down = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", getElement3(i, j));
            }
            System.out.println();

            int[] temp = up;
            up = down;
            down = temp;
            Arrays.fill(down, 0);
        }
    }


    private static int getElement3(int a, int b){
        if (b == 1 || a == b){
            down[b] = 1;
            return 1;
        }
        int x = up[b-1] + up[b];
        down[b] = x;
        return x;
    }
}
