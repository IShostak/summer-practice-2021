package com.ishostak.tasks.task1;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    public String text = "";
    private StringBuilder result = new StringBuilder(text);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void sayHelloWorld() {
        Scanner scanner = new Scanner(System.in);

        view.printText(view.INPUT_DATA);
        text = scanner.nextLine();

        while (!model.isFirstValid(text)) {
            view.printText(view.WRONG_INPUT);
            text = scanner.nextLine();
        }

        result.append(text + " ");
        text = scanner.nextLine();

        while (!model.isSecondValid(text)) {
            view.printText(view.WRONG_INPUT);
            text = scanner.nextLine();
        }

        result.append(text);
        view.printText(result.toString());
    }
}
