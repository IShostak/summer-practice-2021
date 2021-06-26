package com.ishostak.tasks.l2mvcgame;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private boolean gameOver;
    private int randomNumber;
    private int bound = 100;
    private List attempts;

    public void generateNumber(){
        randomNumber = (int)(Math.random() * bound);
    }

    public boolean isOutOfBounds(int number) {
        return number > bound || number < 0;
    }

    public String numberCheck(int number) {
        if (randomNumber == number) return "Win";
        if (number < randomNumber) return "Low";
        return "High";
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

    public List getAttempts() {
        return attempts;
    }

    public void addAttempt(int number) {
        if (attempts == null) {
            attempts = new ArrayList();
        }

        attempts.add(number);
    }

}
