package com.pg.generate.gen;

public class GenEntityTemplate {

    /**
     * @param myPackage   包名
     * @param myTableName 实例类的名称
     * @param myContent   实体类的数据集
     * @return String
     */
    public static String genEntityTemplate(String myPackage, String myTableName, String myContent) {
        return "package " + myPackage + ";\n" +
                "\n" +
                "import io.swagger.annotations.ApiModelProperty;\n" +
                "import lombok.Data;\n" +
                "import java.util.Date;\n" +
                "\n" +
                "@Data\n" +
                "public class " + myTableName + " {\n" +
                "\n" +
                myContent +
                "}\n";
    }

}
