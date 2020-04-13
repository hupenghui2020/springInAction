package com.hph.web;

import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String[] args) {

        System.out.println(new ClassPathResource("ehcache.xml").exists());
    }
}
