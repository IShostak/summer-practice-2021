package com.ishostak.tasks.l2tests.Test;

import com.ishostak.tasks.l2tests.Calculation.Arithmetics;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class TestArithmetics {
    private static Arithmetics a;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout time = new Timeout(1000);

    //@Before
    @BeforeClass
    public static void initializeA() {
        a = new Arithmetics();
    }

    /*
        @After
        @AfterClass
    */

    @Test
    public void testAdd() {
        double res = a.add(3, 7);
        if(res != 10) Assert.fail();

        /*
        Assert.assertTrue( res == 10);
        Assert.assertFalse(res != 10);
        Assert.assertEquals(res, 10.0);
        */
    }

    //@Ignore
    @Test
    public void testMult() {
        double res = a.mult(3, 7);

        if(res != 21) Assert.fail();
    }

    @Test
    public void testDeduct() {
        double res = a.deduct(3, 7);

        if(res != -4) Assert.fail();
    }

    @Test
    public void testDiv() {
        double res = a.div(10, 5);

        if(res != 2) Assert.fail();
    }

   // @Test(expected = ArithmeticException.class)
    public void testDivException() {
        expectedException.expect(ArithmeticException.class);
        a.div(10.0, 0.0);
    }

    @Test(timeout = 1000)
    public void timeOutTest() {

    }
}
