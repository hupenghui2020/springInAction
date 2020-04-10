package com.hph.web;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hph
 */
@Controller
@RequestMapping(value = "/spittles")
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE+"";

    /**
     * 返回的视图根据访问路径判断，也就是spittles
     * 返回的mode的key根据返回类型判断，也就是spittleList
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<Spittle> spittleList(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) int max,
            @RequestParam(value = "count", defaultValue = "20") int count){

        return spittleRepository.findAll(PageRequest.of(max, count));
    }

    /**
     * 获取指定的spittle
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") String spittleId, Model model){

        // key值为spittle，根据添加的属性类型判断
        model.addAttribute(spittleRepository.findById(spittleId));

        return "spittle";
    }
}
