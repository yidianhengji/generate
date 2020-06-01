package com.pg.generate.util;

import java.util.ArrayList;
import java.util.List;

public class Template {

    /**
     * 模板列表
     * @return
     */
    public static List<String> getTemplateVmList() {
        List<String> templates = new ArrayList<>();
        templates.add("templates/java/entity.vm");
        templates.add("templates/java/dao.vm");
        templates.add("templates/java/service.vm");
        templates.add("templates/java/serviceImpl.vm");
        templates.add("templates/java/controller.vm");
        templates.add("templates/xml/mapper.vm");
        return templates;
    }

}
