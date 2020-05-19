package com.hph.web;

import com.hph.model.Spittle;
import com.hph.service.AlertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author hph
 */
@Controller
@RequestMapping(value = "/alert")
public class AlertController {

    @Resource
    private AlertService alertService;

    @RequestMapping(value = "/{spittle}", method = RequestMethod.GET)
    public void sendSpittleAlert(@PathVariable Spittle spittle) {

        alertService.sendSpittleAlert(spittle);
    }
}
