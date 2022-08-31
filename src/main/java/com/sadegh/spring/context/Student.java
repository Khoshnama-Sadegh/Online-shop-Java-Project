package com.sadegh.spring.context;

import lombok.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@PropertySource("classpath:foo.properties")
@Lazy
public class Student {

    @Autowired
    private Logger logger;

    private int age;
    @Value("${candid}")
    private String name;
    private String family;

    @Autowired
    @Qualifier("sportBook")
    private Book book;




    public void init(){
        System.out.println("initialize");
    }

    public int sum(int i,int j){
        return i+j;
    }


}
