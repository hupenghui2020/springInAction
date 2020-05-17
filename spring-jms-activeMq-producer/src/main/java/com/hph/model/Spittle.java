package com.hph.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * @author com.hph
 */
@Data
public class Spittle implements Serializable {

    private String id;

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private double latitude;

    private double longitude;
}
