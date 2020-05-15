package com.pg.generate.gen;

public class GenServiceImpl {

    public static String genServiceImpl(String myPackage, String tableName, String defaultTableName) {
        String genServiceImplTemplate = GenServiceImplTemplate.genServiceImplTemplate(myPackage, tableName, defaultTableName);
        return genServiceImplTemplate;
    }
}
