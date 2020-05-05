package com.hph.web;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\10499\\Desktop\\WHO-COVID-19-global-data.csv"));

        List<DemoObj> readAll = reader.readAll(DemoObj.class);

        Set<String> countrySet = readAll.stream().map(DemoObj::getCountry).collect(Collectors.toSet());
        Set<Map.Entry<Date,List<DemoObj>>> set = readAll.stream().collect(Collectors.groupingBy(DemoObj :: getTime)).entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toCollection(LinkedHashSet::new));
        List<Map<String, Object>> list = new ArrayList<>();
        countrySet.forEach(country -> {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("country", country);
            set.forEach(entry ->{
                List<DemoObj> demoObjList = entry.getValue();
                DemoObj obj = demoObjList.stream().filter(demoObj -> country.equals(demoObj.getCountry())).findFirst().orElse(null);
                row.put(StrUtil.toString(entry.getKey()).split("00:00:00")[0].trim(), ObjectUtil.isEmpty(obj) ? 0 : obj.getNum());
            });
            list.add(row);
        });

        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("C:\\Users\\10499\\Desktop\\data.csv");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        // 关闭writer，释放内存
        writer.close();
    }
}
