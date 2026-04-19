package validBrackets;

import org.junit.Assert;
import org.junit.Test;

import validBrackets.ValidBrackets;


public class TestValidBrackets {
    @Test
    public void Test1(){
        String str1 = "[(]{)}";//f
        String str2 = "[(])";//f
        String str3 = "([{{}}[]])";//t
        String str4 = "(tong(tong[N]B))";//t

        Assert.assertTrue(ValidBrackets.check(str4));
        Assert.assertTrue(ValidBrackets.check(str3));
        Assert.assertFalse(ValidBrackets.check(str2));
        Assert.assertFalse(ValidBrackets.check(str1));
    }
}
