package fibonacci;

import org.junit.Test;

public class TestFibonacci {
    @Test
    public void Test1(){
        long startTime = System.nanoTime();
        int result = FibonacciBasic.getFibonacci(40);
        long endTime = System.nanoTime();

        System.out.println("基础版:");
        System.out.println("结果: " + result);
        System.out.println("耗时: " + (endTime - startTime) / 1_000_000.0 + " 毫秒");
        System.out.println("______________________________________________");
    }


    @Test
    public void Test2(){
        long startTime = System.nanoTime();
        int result = FibonacciAdvance.getFibonacci(40);
        long endTime = System.nanoTime();

        System.out.println("记忆版:");
        System.out.println("结果: " + result);
        System.out.println("耗时: " + (endTime - startTime) / 1_000_000.0 + " 毫秒");
        System.out.println("______________________________________________");
    }
}
