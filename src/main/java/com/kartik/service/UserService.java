package com.kartik.service;

import com.kartik.dao.UserDao;
import com.kartik.dao.interfaces.IUserDao;
import com.kartik.service.inteface.IUserService;
import com.kartik.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("UserService")
public class UserService implements IUserService {

    //UserDao userDao = new UserDao();
    @Autowired
    IUserDao userDao;

    private static String username, password ;
    private static Scanner scanner ;
    static  {
        scanner = new Scanner(System.in);
    }



    //@Override
    public  User validate(User user)  throws Exception {
        user =  userDao.searchUser(user);
       return user;
    }

    //@Override
    public  User requestUserLogin() throws Exception {
        System.out.print("Enter Username : ");
        username = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();

        try {
             User user = validate(new User(username,password));
//            User user = new User();
//            user = validate(user);
            return user;
        } catch (Exception e) {
            System.out.println("Exception while logging in " + e);
//            throw new Exception("Either the username/password you provied is wrong.");
            throw e;
        }
    }


}
