package com.hph.domain;


import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hph
 */

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Customer customer;

    private List<Pizza> pizzas;

    private Payment payment;

    public Order() {
        this.customer = new Customer();
        this.pizzas = new ArrayList<>();
    }
}
