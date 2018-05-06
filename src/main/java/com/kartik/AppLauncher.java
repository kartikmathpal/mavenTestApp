package com.kartik;

import com.kartik.configuration.ApplicationContextBean;
import com.kartik.configuration.HibernateConfigBean;
import com.kartik.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLauncher {


    public static void main(String [] args) {

       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

       ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextBean.class);


//        applicationContext.getBean("");

//        Controller controller = new Controller();

//        controller.initialize();

    }

}
