package com.hph.web;

import com.hph.model.Spitter;
import com.hph.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Part;
import javax.validation.Valid;

/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @Resource
    private AlertService alertService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){

        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String showLoginForm(){

        return "successful";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Spitter spitter, Errors errors,
                                          @RequestPart("profilePicture") Part profilePicture,
                                          RedirectAttributes model){

        if(errors.hasErrors()){
            return "registerForm";
        }
        spitter.setPicName(profilePicture.getSubmittedFileName());
        model.addFlashAttribute(spitter);
        alertService.sendSpitterAlert(spitter);
        return "redirect:/spitter/success";
    }
}
