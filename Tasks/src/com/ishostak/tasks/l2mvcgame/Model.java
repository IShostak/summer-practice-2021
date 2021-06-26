package com.ishostak.tasks.l2mvcgame;

import java.util.Random;

public class Model {
    private boolean gameOver;
    private int randomNumber;
    private int bound = 100;

    public void generateNumber(){
        randomNumber = (int)(Math.random() * bound);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public boolean isCorrectNumber(int number) {
        return randomNumber == number;
    }
}
