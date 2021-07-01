package com.ishostak.tasks.lec2tests.MvcGameTest;

import com.ishostak.tasks.lec2mvcgame.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class Test {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private static Model model;
    private int number;

    @BeforeClass
    public static void Tests() {
        model = new Model();
    }

    @Before
    public void initialIzeRandom() {
        model.generateNumber();
        number = model.getRandomNumber();
    }

    @org.junit.Test
    public void checkRandomNumberRange() {
        if (number > model.getTopBound()) Assert.fail();
        if (number < model.getLowBound()) Assert.fail();
    }

    @org.junit.Test
    public void checkWin() {
        String result;
        int winningNumber = -1;

        for (int i = 0; i < 100; i++ ) {
            if (i == number) {
                winningNumber = number;
                break;
            }
        }

        result = model.numberCheck(winningNumber);
        Assert.assertEquals("Win",result);
    }

    @org.junit.Test
    public void checkHigh() {
        String result;
        int winningNumber = -1;

        for (int i = 0; i < 100; i++ ) {
            if (i == number) {
                winningNumber = number;
                break;
            }
        }

        result = model.numberCheck(winningNumber + 1);
        Assert.assertEquals("High", result);
    }

    @org.junit.Test
    public void checkLow() {
        String result;
        int winningNumber = -1;

        for (int i = 0; i < 100; i++ ) {
            if (i == number) {
                winningNumber = number;
                break;
            }
        }

        result = model.numberCheck(winningNumber - 1);
        Assert.assertEquals("Low", result);
    }
}
