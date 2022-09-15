package com.sadegh.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        String username="admin";
        String password="sadegh";
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encPass=encoder.encode(password);

        System.out.println(encPass);
    }
}
