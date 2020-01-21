package com.hph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hph
 */
@Controller
@RequestMapping(value = {"/homepage"})
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
