package com.hph.web;

import com.hph.data.SpitterRepository;
import com.hph.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.Part;
import javax.validation.Valid;

/**
 * @author hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){

        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(){

        return "login";
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
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model){

        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        // key值为spitter，根据添加的属性类型判断
        model.addAttribute(spitterRepository.findOne(Example.of(spitter)));
        return "profile";
    }
}
