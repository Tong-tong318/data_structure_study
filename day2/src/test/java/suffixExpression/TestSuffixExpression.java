package suffixExpression;

import org.junit.Assert;
import org.junit.Test;

public class TestSuffixExpression {
    @Test
    public void Test1(){
        String str1 = "12 34 30 + -";
        String str2 = "12 3 4 * /";
        String str3 = "3 4 11 * +";
        String str4 = "10 6 9 3 + -11 * / * 17 + 5 +";

        SuffixExpression se = new SuffixExpression();
        int count1 = se.calculate(str1);
        int count2 = se.calculate(str2);
        int count3 = se.calculate(str3);
        int count4 = se.calculate(str4);

        Assert.assertEquals(-52, count1);
        Assert.assertEquals(1, count2);
        Assert.assertEquals(47, count3);
        Assert.assertEquals(22, count4);
    }

    @Test
    public void Test2(){
        String str1 = "1 + 2 * 3";
        String str2 = "1 * 2 + 3";
        String str3 = "3 + 5 + 7";
        String str4 = "2 + ( 3 + 5 ) * 6";

        String str5 = "1 + ( + 3";


        SuffixExpression se = new SuffixExpression();
        Assert.assertEquals("1 2 3 * +", se.myChange(str1));
        Assert.assertEquals("1 2 * 3 +", se.myChange(str2));
        Assert.assertEquals("3 5 + 7 +", se.myChange(str3));
        Assert.assertEquals("2 3 5 + 6 * +", se.myChange(str4));
        Assert.assertThrows("中缀表达式括号有误！", RuntimeException.class, () -> {
            se.myChange(str5);
        });

    }

    @Test
    public void Test3(){
        String str1 = "1 + 2 * 3";
        String str2 = "1 * 2 + 3";
        String str3 = "3 + 5 + 7";
        String str4 = "2 + ( 3 + 5 ) * 6";

        String str5 = "1 + ( + 3";


        SuffixExpression se = new SuffixExpression();
        Assert.assertEquals("1 2 3 * +", se.advanceChange(str1));
        Assert.assertEquals("1 2 * 3 +", se.advanceChange(str2));
        Assert.assertEquals("3 5 + 7 +", se.advanceChange(str3));
        Assert.assertEquals("2 3 5 + 6 * +", se.advanceChange(str4));
        Assert.assertThrows("中缀表达式括号有误！", RuntimeException.class, () -> {
            se.advanceChange(str5);
        });

    }

    @Test
    public void Test4(){
        String str1 = "( 2 + 5 ) / ( 3 - 1 )";
        String str2 = "2 * [ 4 * ( 3 - 1 ) ] ";

        SuffixExpression se = new SuffixExpression();
        Assert.assertEquals("2 5 + 3 1 - /", se.advanceChange(str1));
        Assert.assertEquals("2 4 3 1 - * *", se.advanceChange(str2));
    }
}
