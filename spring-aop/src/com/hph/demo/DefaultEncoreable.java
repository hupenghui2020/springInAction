package com.hph.demo;

/**
 * 新引进的接口的默认实现
 */
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {

        System.out.println("为Performance的实现新引进的接口");
    }
}
