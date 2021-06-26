package com.ishostak.tasks.l2mvcgame;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        model.generateNumber();

        view.printGameStart();

        while (!model.isGameOver()) {
            int number = returnValidInt(scanner);

            String result = model.numberCheck(number);

            switch (result) {
                case "Win": {
                    model.setGameOver(true);
                    model.addAttempt(number);

                    view.printStats(model.getAttempts());
                    view.printWin();
                    view.printEndGame();
                    break;
                }

                case "Low": {
                    model.addAttempt(number);

                    view.printAttempts(model.getAttempts());
                    view.printLowValue();
                    break;
                }

                case "High" : {
                    model.addAttempt(number);

                    view.printAttempts(model.getAttempts());
                    view.printHighValue();
                    break;
                }
            }
        }
    }

    public int returnValidInt(Scanner scanner) {
        int number = returnNextInteger(scanner);

        while (model.isOutOfBounds(number)) {
            view.printOutOfBounds();
            number = returnNextInteger(scanner);
        }

        return number;
    }

    public int returnNextInteger(Scanner scanner) {
        String line = scanner.nextLine();
        int number;

        while (!isInteger(line)) {
            line = scanner.nextLine();
        }

       return number = Integer.parseInt(line);
    }

    public boolean isInteger(String line) {

        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            view.printNumberFormatError();
            return false;
        }

        return true;
    }

}
