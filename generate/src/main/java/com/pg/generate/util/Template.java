package com.pg.generate.util;

import java.util.ArrayList;
import java.util.List;

public class Template {

    /**
     * 模板列表
     * @return
     */
    public static List<String> getTemplateList() {
        List<String> templates = new ArrayList<String>();
        templates.add("java/entity");
        templates.add("java/dao");
        templates.add("java/service");
        templates.add("java/serviceImpl");
        templates.add("java/controller");
        return templates;
    }

}
