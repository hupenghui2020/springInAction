package com.hph.web;

import com.hph.model.Spitter;
import com.hph.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;


/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @Resource
    private SpitterService spitterService;

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
    public String processRegistrationForm(Spitter spitter, Errors errors,
                                          RedirectAttributes model){

        if(errors.hasErrors()){
            return "registerForm";
        }
        model.addFlashAttribute(spitter);
        spitterService.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model){

        // key值为spitter，根据添加的属性类型判断
        model.addAttribute(spitterService.findOneByUsername(username));
        return "profile";
    }
}
