package com.hph.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hph
 */

@Entity
@Table(name = "spittle")
@Data
public class Spittle {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "message", unique = true, nullable = false, length = 36)
    private String message;

    @Column(name = "time", unique = true, nullable = false, length = 36)
    private Date time;

    @Column(name = "latitude", unique = true, nullable = false, length = 36)
    private Double latitude;

    @Column(name = "longitude", unique = true, nullable = false, length = 36)
    private Double longitude;
}
