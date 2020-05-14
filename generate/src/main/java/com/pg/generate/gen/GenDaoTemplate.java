package com.pg.generate.gen;

public class GenDaoTemplate {

    /**
     * @param myPackage          包名
     * @param myTableName        实体类的名称
     * @param myDefaultTableName 默认的数据库名称，已转驼峰
     * @return
     */
    public static String genDaoTemplate(String myPackage, String myTableName, String myDefaultTableName) {

        return "package " + myPackage + ";\n" +
                "\n" +
                "import com.github.pagehelper.Page;\n" +
                "import com.pg.generate.entity." + myTableName + ";\n" +
                "\n" +
                "import java.util.List;\n" +
                "\n" +
                "public interface " + myTableName + "Mapper {\n" +
                "\n" +
                "    Page<" + myTableName + "> queryPage(" + myTableName + " " + myDefaultTableName + ");\n" +
                "\n" +
                "    List<" + myTableName + "> queryAll();\n" +
                "\n" +
                "    " + myTableName + " queryOne(String uuid);\n" +
                "\n" +
                "    int insert(" + myTableName + " " + myDefaultTableName + ");\n" +
                "\n" +
                "    int update(" + myTableName + " " + myDefaultTableName + ");\n" +
                "\n" +
                "    int delete(String uuid);\n" +
                "\n" +
                "}\n";
    }
}
