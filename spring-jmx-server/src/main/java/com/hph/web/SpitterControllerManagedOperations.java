package com.hph.web;

/**
 * 用于定义 JMX Bean 暴露的属性
 * @author 10499
 */
public interface SpitterControllerManagedOperations {

    int getSpitterPerPage();

    void setSpitterPerPage(int spitterPerPage);
}
