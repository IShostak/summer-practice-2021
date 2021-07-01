package com.ishostak.tasks.lec1mvchelloworld;

public class Main {
    public static void main(String[] args) {
        Model mainModel = new Model();
        View mainView = new View();
        Controller main = new Controller(mainModel, mainView);

        main.sayHelloWorld();
    }
}
