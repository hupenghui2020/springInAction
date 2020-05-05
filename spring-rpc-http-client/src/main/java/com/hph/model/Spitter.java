package com.hph.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;


/**
 * 注册的用户
 * @author com.hph
 */

@Entity
@Table(name = "spitter")
@Data
public class Spitter implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "first_name", unique = true, nullable = false, length = 36)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false, length = 36)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 36)
    private String email;

    @Column(name = "username", unique = true, nullable = false, length = 36)
    private String username;

    @Column(name = "password", unique = true, nullable = false, length = 36)
    private String password;

    @Column(name = "pic_name", unique = true, nullable = false, length = 36)
    private String picName;
}
