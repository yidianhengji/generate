package com.pg.generate.controller;

import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.service.GenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "test")
public class Test {

    @Resource
    private GenService genService;

    @PostMapping
    public int ee() {
        GenTableInfo genTableInfo = new GenTableInfo();
        genTableInfo.setTableSchema("bbs_sifou");
        genTableInfo.setTableName("tb_recommend");
        genService.GenEntity(genTableInfo);
        return 0;
    }
}
