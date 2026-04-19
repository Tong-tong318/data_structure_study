package heap;

import org.junit.Assert;
import org.junit.Test;

public class TestExampleFindmid {
    @Test
    public void Test1(){
        Example_findMid test = new Example_findMid();
        test.add(23);
        test.add(14);
        test.add(546);
        test.add(245);
        test.add(241);
        test.add(53);
        test.add(12);

        Assert.assertEquals(53.0, test.getMid(), 0.0001);
    }
}
