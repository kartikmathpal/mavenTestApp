package com.kartik.dao;

import com.kartik.dao.interfaces.IUserDao;
import com.kartik.entity.User;
import com.kartik.exceptions.InvalidUserCredentialsException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("UserDao")
public class UserDao implements IUserDao {

//    private static List<User> users;

//    static {
//        users = new ArrayList<User>();
//
//        users.add(new User("kartik","mathpal"));
//        users.add(new User("mayank","lohani"));
//    }


    @Autowired
    private SessionFactory sessionFactory;

    //@Override
    public   User searchUser(User user) throws Exception{
//        Boolean userFound = false;
//        for(User user1: users) {
//            if(user1.getUserName().equalsIgnoreCase(user.getUserName())
//                    && user1.getPassword().equalsIgnoreCase(user.getPassword())){
//                    userFound = true;
//                    user = user1;
//            }
//        }
        //System.out.println(user.getUsername());

//        user = (User) sessionFactory
//                .getCurrentSession()
//                .createQuery("from User where username=:username and password=:password")
//                .setParameter("username", user.getUsername())
//                .setParameter("password", user.getPassword())
//                .uniqueResult();

//        user = (User) sessionFactory
//                .getCurrentSession()
//                .createCriteria(User.class)
//                .add(
//                        Restrictions.and(
//                                Restrictions.eq("username", user.getUsername()),
//                                Restrictions.eq("password", user.getPassword())
//                        )
//                )
//                .uniqueResult();

        user = (User) sessionFactory
                .getCurrentSession()
                .createSQLQuery("select username as username, password as password from User where username=:username and password=:password")
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .addScalar("username")
                .addScalar("password")
                .setResultTransformer(Transformers.aliasToBean(User.class))
                .uniqueResult();



        if(user == null) {
            throw new InvalidUserCredentialsException("Invalid user credentials provided");
        } else {
            return user;
        }
    }

    //-------------------------update
//    public User createUpdateUser(User user) throws Exception {
//        return (User) sessionFactory.getCurrentSession().merge(user);
//    }
}
