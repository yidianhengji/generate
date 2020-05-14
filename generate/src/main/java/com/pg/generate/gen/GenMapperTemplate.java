package com.pg.generate.gen;

public class GenMapperTemplate {

    public static String genMapperTemplate(
            String myMapperNamePackage,
            String myEntityNamePackage,
            String myMapperName,
            String myTableName,
            String myColumnKey,
            String myResultContent
    ) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "<mapper namespace=\"" + myMapperNamePackage + "\">\n" +
                "\n" +
                "   <resultMap type=\"" + myEntityNamePackage + "\" id=\"" + myMapperName + "Map\">\n" +
                myResultContent +
                "   </resultMap>\n" +
                "\n" +
                "   <select id=\"queryPage\" resultMap=\"" + myMapperName + "Map\">\n" +
                "       SELECT * FROM " + myTableName + "\n" +
                "   </select>\n" +
                "\n" +
                "   <select id=\"queryAll\" resultMap=\"" + myMapperName + "Map\">\n" +
                "       SELECT * FROM " + myTableName + "\n" +
                "   </select>\n" +
                "\n" +
                "   <select id=\"queryOne\" resultMap=\"" + myMapperName + "Map\">\n" +
                "       SELECT * FROM " + myTableName + " WHERE "+myColumnKey+" = ${uuid}\n" +
                "   </select>\n" +
                "\n" +
                "</mapper>";
    }
}
