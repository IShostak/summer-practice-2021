package com.ishostak.tasks.l2mvcgame;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private boolean gameOver;
    private int randomNumber;
    private int topBound = 100;
    private int lowBound = 0;
    private String boundariesMessage;
    private List attempts;

    public void generateNumber(){
        randomNumber = (int)(Math.random() * topBound);
    }

    public boolean isOutOfBounds(int number) {
        return number > topBound || number < lowBound;
    }

    public String numberCheck(int number) {
        if (randomNumber == number) return "Win";
        if (number < randomNumber) {
            if (number > lowBound) lowBound = number;

            return "Low";
        }

        if (randomNumber < topBound) topBound = number;

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

    public int getTopBound() {
        return topBound;
    }

    public void setTopBound(int topBound) {
        this.topBound = topBound;
    }

    public int getLowBound() {
        return lowBound;
    }

    public void setLowBound(int lowBound) {
        this.lowBound = lowBound;
    }

    public String getBoundariesMessage() {
        boundariesMessage = "Between " + lowBound + " and " + topBound;
        return boundariesMessage;
    }

    public void setBoundariesMessage(String boundariesMessage) {
        this.boundariesMessage = boundariesMessage;
    }

    public void addAttempt(int number) {
        if (attempts == null) {
            attempts = new ArrayList();
        }

        attempts.add(number);
    }

}
