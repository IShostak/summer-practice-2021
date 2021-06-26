package com.ishostak.tasks.l2mvcgame;

import java.util.List;

public class View {

    private final String GAME_START = "Starting game. \n" +
            "Number should be between 0 and 100.\n" +
            "You first guess:";

    private final String LOW_VALUE = "To low. Try something bigger";
    private final String HIGH_VALUE = "To high. Try something lower";
    private final String OUT_OF_BOUNDS = "Should be between 0 and 100";
    private final String WIN = "Congratulations. You're winner!";
    private final String END_GAME = "Closing the game. See you soon";
    private final String NUMBER_FORMAT_ERROR = "Not a number. Please, enter number between 0 and 100:";

    public void printAttempts(List attempts) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < attempts.size(); i++) {
            result.append(attempts.get(i));
            result.append(", ");
        }

        System.out.print("Your attempts: [");
        System.out.print(result.substring(0,result.length() - 2));
        System.out.println("]");
    }

    public void printStats(List attempts) {
        System.out.println("Overall attempts: " + attempts.size());
        System.out.println("History: ");

        printAttempts(attempts);
    }

    public void printOutOfBounds() {
        System.out.println(OUT_OF_BOUNDS);
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printLowValue() {
        System.out.println(LOW_VALUE);
    }

    public void printHighValue() {
        System.out.println(HIGH_VALUE);
    }

    public void printWin() {
        System.out.println(WIN);
    }

    public void printEndGame() {
        System.out.println(END_GAME);
    }

    public void printNumberFormatError() {
        System.out.println(NUMBER_FORMAT_ERROR);
    }
}
