package com.hph.model;

import lombok.Data;

import java.util.Date;

/**
 * @author hph
 */

@Data
public class Spittle {

    private int id;

    private String message;

    private Date time;

    private Double latitude;

    private Double longitude;
}
