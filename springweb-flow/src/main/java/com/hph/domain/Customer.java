package com.hph.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author com.hph
 */
@Data
public class Customer implements Serializable {

    private String phoneNumber;

    private String zipCode;

    private String name;

    private String address;

    private String city;

    private String state;
}
