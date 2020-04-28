package com.hph.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hph
 */

@Data
public class Spittle implements Serializable {

    private String id;

    private String message;

    private Date createTime;

    private double latitude;

    private double longitude;
}
