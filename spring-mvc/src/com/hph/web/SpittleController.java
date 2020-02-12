package com.hph.web;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hph
 */
@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 返回的视图根据访问路径判断，也就是spittles
     * 返回的mode的key根据返回类型判断，也就是spittleList
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittleList(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count){

        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 获取指定的spittle
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model){

        model.addAttribute(spittleRepository.findOne(spittleId));

        return "spittle";
    }
}
