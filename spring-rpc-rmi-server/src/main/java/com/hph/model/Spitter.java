package com.hph.model;

import lombok.Data;

import java.io.Serializable;


/**
 * 注册的用户
 * @author hph
 */

@Data
public class Spitter implements Serializable {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String picName;
}
