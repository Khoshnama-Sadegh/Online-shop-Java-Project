package com.sadegh.spring.context;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    Logger logger=Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main main=new Main();
        main.f();











    }

    public void f(){
        int i=17;
        logger.info(String.format("this is in f method and value of i is %d",i));
    }

}

