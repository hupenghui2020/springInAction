package com.hph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController implements SpitterControllerManagedOperations{

    public static final int DEFAULT_SPITTER_PER_PAGE = 25;

    private int spitterPerPage = DEFAULT_SPITTER_PER_PAGE;

    @Override
    public int getSpitterPerPage() {
        return spitterPerPage;
    }

    @Override
    public void setSpitterPerPage(int spitterPerPage) {
        this.spitterPerPage = spitterPerPage;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(){

        return "registerForm";
    }
}
