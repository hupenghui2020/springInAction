package com.hph.web;

public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sdawf").append(",");
        System.out.println(stringBuilder.deleteCharAt(stringBuilder.length()-1));
    }
}
