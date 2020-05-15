package com.pg.generate.gen;

public class GenServiceImplTemplate {

    public static String genServiceImplTemplate(String myPackage, String tableName, String defaultTableName) {
        return "package " + myPackage + ".service.impl;\n" +
                "\n" +
                "import com.github.pagehelper.Page;\n" +
                "import com.github.pagehelper.PageHelper;\n" +
                "import com.github.pagehelper.util.StringUtil;\n" +
                "import " + myPackage + ".dao." + tableName + "Mapper;\n" +
                "import " + myPackage + ".entity." + tableName + ";\n" +
                "import " + myPackage + ".handler.BusinessException;\n" +
                "import " + myPackage + ".service." + tableName + "Service;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "\n" +
                "import javax.annotation.Resource;\n" +
                "import java.util.Date;\n" +
                "import java.util.List;\n" +
                "import java.util.UUID;\n" +
                "\n" +
                "@Service\n" +
                "public class " + tableName + "ServiceImpl implements " + tableName + "Service {\n" +
                "\n" +
                "    @Resource\n" +
                "    private " + tableName + "Mapper " + defaultTableName + "Mapper;\n" +
                "\n" +
                "    @Override\n" +
                "    public Page<" + tableName + "> queryPage(" + tableName + " " + defaultTableName + ") {\n" +
                "        if (" + defaultTableName + ".getPageSize() != null && " + defaultTableName + ".getPageNum() != null) {\n" +
                "            PageHelper.startPage(" + defaultTableName + ".getPageNum(), " + defaultTableName + ".getPageSize());\n" +
                "        }\n" +
                "        Page<" + tableName + "> pages = this." + defaultTableName + "Mapper.queryPage(" + defaultTableName + ");\n" +
                "        return pages;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public List<" + tableName + "> queryAll() {\n" +
                "        List<" + tableName + "> list = this." + defaultTableName + "Mapper.queryAll();\n" +
                "        return list;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public " + tableName + " queryOne(String uuid) {\n" +
                "        " + tableName + " one = this." + defaultTableName + "Mapper.queryOne(uuid);\n" +
                "        return one;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public int insert(" + tableName + " " + defaultTableName + ") {\n" +
                "        " + defaultTableName + ".setUuid(UUID.randomUUID().toString().replace(\"-\", \"\"));\n" +
                "        " + defaultTableName + ".setCreateTime(new Date());\n" +
                "        " + defaultTableName + ".setModifyTime(new Date());\n" +
                "        return this." + defaultTableName + "Mapper.insert(" + defaultTableName + ");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public int update(" + tableName + " " + defaultTableName + ") {\n" +
                "        if (StringUtil.isEmpty(" + defaultTableName + ".getUuid())) {\n" +
                "            throw new BusinessException(500, \"uuid必传\");\n" +
                "        }\n" +
                "        " + defaultTableName + ".setModifyTime(new Date());\n" +
                "        return this." + defaultTableName + "Mapper.update(" + defaultTableName + ");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public int delete(String uuid) {\n" +
                "        return this." + defaultTableName + "Mapper.delete(uuid);\n" +
                "    }\n" +
                "}\n";
    }
}
