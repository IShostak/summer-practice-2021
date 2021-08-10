package com.ishostak.toursoverplanet;

import com.ishostak.toursoverplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TOPApplication {

    public static void main(String[] args) {

        SpringApplication.run(TOPApplication.class, args);
    }

}
