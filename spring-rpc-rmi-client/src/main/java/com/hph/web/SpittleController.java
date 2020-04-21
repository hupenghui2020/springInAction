package com.hph.web;

import com.hph.data.SpittleRepository;
import com.hph.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
    @GetMapping
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
    @GetMapping(value = "/{spittleId}")
    public String findBySpittleId(@PathVariable("spittleId") String spittleId, Model model){

        // key值为spittle，根据添加的属性类型判断
        model.addAttribute(spittleRepository.findOneSpittle(spittleId));
        return "spittle";
    }

    @DeleteMapping(value = "/{spittleId}")
    public String removeSpittle(@PathVariable("spittleId") String spittleId){

        // key值为spittle，根据添加的属性类型判断
        spittleRepository.removeSpittle(spittleId);
        return "removeSuccessful";
    }

    @GetMapping(value = "/save")
    public String toAddSpittle(Model model){

        model.addAttribute(new Spittle());
        return "addSpittle";
    }

    @PostMapping(value = "/save")
    public String saveSpittle(Spittle spittle){

        spittleRepository.saveSpittle(spittle);
        return "successful";
    }
}
