package com.kartik.controller;

import com.kartik.entity.User;
import com.kartik.entity.Train;
import com.kartik.exceptions.InvalidUserCredentialsException;
import com.kartik.service.TrainService;
import com.kartik.service.UserService;
import com.kartik.service.inteface.ITrainService;
import com.kartik.service.inteface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component("appController")
public class Controller {
    private static Scanner scanner;

    @Autowired
    IUserService userService ;

    @Autowired
    ITrainService trainService;
    //static TrainService  trainService = new TrainService();

    public Controller() {
    }

    @PostConstruct
    public void initialize() {
        try {
            User user = userService.requestUserLogin();
            System.out.println("Login was succesfull for user" + user);

            // if login successfully then enter to train service
                try{
                    List<Train> trains =  trainService.requestUserInput();
                        //System.out.println("In Controller");

                    System.out.println(trains);
                }
                catch (Exception e){
                    System.out.println(e);
                }


        } catch (Exception e) {
            if(e instanceof InvalidUserCredentialsException) {
                System.out.println("user login exceptoin");
            } else {
            System.out.println("some other failure: " + e);
            }

        }

    }


}
