package com.ishostak.tasks.l2mvcgame;

public class Main {
    public static void main(String[] args) {
        new Controller(new Model(), new View()).startGame();
    }
}
