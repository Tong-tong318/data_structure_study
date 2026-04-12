package suffixExpression;

import org.junit.Assert;
import org.junit.Test;

public class TestSuffixExpression {
    @Test
    public void Test1(){
        String str1 = "12 34 30 + -";
        String str2 = "12 3 4 * /";
        String str3 = "3 4 11 * +";

        SuffixExpression se = new SuffixExpression();
        int count1 = se.calculate(str1);
        int count2 = se.calculate(str2);
        int count3 = se.calculate(str3);

        Assert.assertEquals(-52, count1);
        Assert.assertEquals(1, count2);
        Assert.assertEquals(47, count3);
    }



}
