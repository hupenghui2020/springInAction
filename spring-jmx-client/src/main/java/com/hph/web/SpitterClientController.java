package com.hph.web;

import com.hph.data.SpitterRepository;
import com.hph.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterClientController implements SpitterControllerManagedOperations{

    @Resource
    private MBeanProxyFactoryBean mBeanProxyFactoryBean;

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

    @Autowired
    private SpitterRepository spitterRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){

        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(Spitter spitter, Errors errors,
                                          RedirectAttributes model){

        if(errors.hasErrors()){
            return "registerForm";
        }
        model.addFlashAttribute(spitter);
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }
}
