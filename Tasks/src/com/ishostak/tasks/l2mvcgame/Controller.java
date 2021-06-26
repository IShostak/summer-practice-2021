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

        System.out.println(view.getGAME_START());

        while (!model.isGameOver()) {
            int number = returnNextInteger(scanner);

            if (model.isCorrectNumber(number)) {

            }
        }
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
            System.out.println(view.getNUMBER_FORMAT_ERROR());
            return false;
        }

        return true;
    }


}
