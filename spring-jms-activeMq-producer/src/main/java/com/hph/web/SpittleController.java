package com.hph.web;

import com.hph.model.Spitter;
import com.hph.model.Spittle;
import com.hph.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author com.hph
 */
@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    @Autowired
    private SpittleService spittleService;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){

        model.addAttribute(new Spitter());
        return "registerForm";
    }

    /**
     * 返回的视图根据访问路径判断，也就是spittles
     * 返回的mode的key根据返回类型判断，也就是spittleList
     * @return
     */
    @GetMapping
    public Object spittleList(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) int max,
            @RequestParam(value = "count", defaultValue = "20") int count){

        return spittleService.findAll(max, count);
    }

    /**
     * 获取指定的spittle
     * @param spittleId
     * @param model
     * @return
     */
    @GetMapping(value = "/{spittleId}")
    public String findBySpittleId(@PathVariable("spittleId") String spittleId, Model model){

        // key值为spittle，根据添加的属性类型判断
        model.addAttribute(spittleService.findOneSpittle(spittleId));
        return "spittle";
    }

    @DeleteMapping(value = "/{spittleId}")
    public String removeSpittle(@PathVariable("spittleId") String spittleId){

        // key值为spittle，根据添加的属性类型判断
        spittleService.removeSpittle(spittleId);
        return "removeSuccessful";
    }

    @GetMapping(value = "/save")
    public String toAddSpittle(Model model){

        model.addAttribute(new Spittle());
        return "addSpittle";
    }

    @PostMapping(value = "/save")
    public String saveSpittle(Spittle spittle){

        spittleService.saveSpittle(spittle);
        return "successful";
    }
}
