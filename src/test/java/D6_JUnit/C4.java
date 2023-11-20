package D6_JUnit;

import org.junit.Assert;
import org.junit.Test;

public class C4 {

    @Test
    public void test01(int s1, int s2, int s3) {

        s1 = 10;
        s2 = 20;
        s3 = 30;


        Assert.assertTrue(s1 < s2);

    }
}
