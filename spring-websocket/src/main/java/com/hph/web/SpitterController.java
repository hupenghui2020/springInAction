package com.hph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String showLoginForm(){

        return "successful";
    }
}
