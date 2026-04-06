package yanghuiTryangle;

import java.util.Arrays;

public class YanghuiTryangleBasic {

    static int[][] arr;

    public static void print1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-4d", getElement1(i, j));
            }
            System.out.println();
        }
    }
    private static int getElement1(int a, int b){
        if (b == 1 || a == b){
            return 1;
        }

        return getElement1(a-1, b) + getElement1(a-1, b-1);
    }
}
