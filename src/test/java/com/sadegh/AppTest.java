//package com.sadegh;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import static org.junit.Assert.*;
//
///**
// * Unit test for simple App.
// */
//public class AppTest
//{
//    /**
//     * Rigorous Test :-)
//     */
//
//    ApplicationContext context;
//
//    @Before
//    public void init(){
////        context=new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        context=new AnnotationConfigApplicationContext(ContextConfig.class);
//
//    }
//
//    @Test
//    public void checkSingletonInitStudent(){
//        Student student = (Student) context.getBean("student");
//        Student student2=(Student)context.getBean("student");
//        System.out.println(student);
//
//        assertTrue(student==student2);
//    }
//
//
//    @Test
//    public void sumMethodShouldSumTwoIntValues(){
//
//        Student student=new Student();
//        int actual= student.sum(3,4);
//        assertEquals(7,actual);
//    }
//
//
//
//    @Test
//    public void studentMustHaveNameWhenInitialized(){
//        Student student= (Student) context.getBean("student");
//        assertEquals("ali",student.getName());
//
//    }
//
//
//    @Test
//    public void studentMustHaveBookWhenInitialized(){
//        Student student= (Student) context.getBean("student");
//        assertNotEquals(null,student.getBook());
//
//    }
//
//
//
//
//
//    @After
//    public void close(){
//
//        ((ConfigurableApplicationContext)context).close();
//    }
//}
