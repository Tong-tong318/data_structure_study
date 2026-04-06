package yanghuiTryangle;

import org.junit.Test;

public class TestYanghuiTryangleBasic {

    @Test
    public void Test1(){
        System.out.println("基础版:");
        System.out.println("结果: ");

        long startTime = System.nanoTime();
        YanghuiTryangleBasic.print1(10);
        long endTime = System.nanoTime();

        System.out.println("耗时: " + (endTime - startTime) / 1_000_000.0 + " 毫秒");
        System.out.println("______________________________________________");

    }

    @Test
    public void Test2(){
        System.out.println("记忆版:");
        System.out.println("结果: ");

        long startTime = System.nanoTime();
        YanghuiTryangleAdvance.print2(10);
        long endTime = System.nanoTime();

        System.out.println("耗时: " + (endTime - startTime) / 1_000_000.0 + " 毫秒");
        System.out.println("______________________________________________");

    }
}
