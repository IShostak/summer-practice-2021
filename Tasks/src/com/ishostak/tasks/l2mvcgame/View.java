package com.ishostak.tasks.l2mvcgame;

import java.util.List;

public class View {

    private final String GAME_START = "Starting game. \n" +
            "If you want to exit. Enter \"Exit\" \n" +
            "You first guess:";

    private final String LOW_VALUE = "To low. Your number should be between 0 and 100. Try something bigger";
    private final String HIGH_VALUE = "To high. Your number should be between 0 and 100. Try something lower";
    private final String WIN = "Congratulations. You're winner!";
    private final String END_GAME = "Closing the game. See you soon";
    private final String NUMBER_FORMAT_ERROR = "Not a number. Please, enter number between 0 and 100:";

    public void printAttempts(List attempts) {
        attempts.forEach(x -> System.out.print(x+ " "));
        System.out.println();
    }

    public void printStats(List attempts) {
        System.out.println("Overall attempts: " + attempts.size());
        System.out.println("History: ");

        printAttempts(attempts);
    }

    public String getGAME_START() {
        return GAME_START;
    }

    public String getLOW_VALUE() {
        return LOW_VALUE;
    }

    public String getHIGH_VALUE() {
        return HIGH_VALUE;
    }

    public String getWIN() {
        return WIN;
    }

    public String getEND_GAME() {
        return END_GAME;
    }

    public String getNUMBER_FORMAT_ERROR() {
        return NUMBER_FORMAT_ERROR;
    }
}
