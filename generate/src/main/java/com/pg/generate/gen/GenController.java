package com.pg.generate.gen;

public class GenController {

    public static String genController(String myPackage, String tableName, String defaultTableName, String tableComment) {
        String genController = GenControllerTemplate.genControllerTemplate(myPackage, tableName, defaultTableName, tableComment);
        return genController;
    }
}
