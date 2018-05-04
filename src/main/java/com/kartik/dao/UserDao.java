package com.kartik.dao;

import com.kartik.dao.interfaces.IUserDao;
import com.kartik.entity.User;
import com.kartik.exceptions.InvalidUserCredentialsException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("UserRepo")
public class UserDao implements IUserDao {

    private static List<User> users;

    static {
        users = new ArrayList<User>();

        users.add(new User("kartik","mathpal"));
        users.add(new User("mayank","lohani"));
    }


    @Autowired
    private SessionFactory sessionFactory;

    //@Override
    public   User searchUser(User user) throws Exception{
        Boolean userFound = false;
        for(User user1: users) {
            if(user1.getUserName().equalsIgnoreCase(user.getUserName())
                    && user1.getPassword().equalsIgnoreCase(user.getPassword())){
                    userFound = true;
                    user = user1;
            }
        }

        if(!userFound) {
            throw new InvalidUserCredentialsException("Invalid user credentials provided");
        } else {
            return user;
        }
    }
}
