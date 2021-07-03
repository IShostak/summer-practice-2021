package com.ishostak.tasks.lec4_consoleregistration;


import com.ishostak.tasks.lec4_consoleregistration.mvc.Controller;
import com.ishostak.tasks.lec4_consoleregistration.mvc.Model;
import com.ishostak.tasks.lec4_consoleregistration.mvc.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.startRegistration();
    }
}
