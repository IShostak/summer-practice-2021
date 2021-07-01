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
        int winningNumber = -1;

        for (int i = 0; i < 100; i++ ) {
            if (i == number) {
                winningNumber = number;
                break;
            }
        }
        Assert.assertEquals(number, winningNumber);
    }

    @org.junit.Test
    public void checkLose() {
        int winningNumber = -1;

        for (int i = 0; i < 100; i++ ) {
            if (i == number) {
                winningNumber = number;
                break;
            }
        }
        Assert.assertFalse(number != winningNumber);
    }
}
