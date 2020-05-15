package com.pg.generate.gen;

public class GenControllerTemplate {

    public static String genControllerTemplate(String myPackage, String tableName, String defaultTableName, String tableComment) {
        return "" +
                "package " + myPackage + ".controller;\n" +
                "\n" +
                "import com.github.pagehelper.Page;\n" +
                "import " + myPackage + ".entity." + tableName + ";\n" +
                "import " + myPackage + ".handler.BusinessStatus;\n" +
                "import " + myPackage + ".handler.PageInfo;\n" +
                "import " + myPackage + ".handler.Result;\n" +
                "import " + myPackage + ".handler.ResultPage;\n" +
                "import " + myPackage + ".service." + tableName + "Service;\n" +
                "import io.swagger.annotations.Api;\n" +
                "import io.swagger.annotations.ApiOperation;\n" +
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "\n" +
                "import javax.annotation.Resource;\n" +
                "import java.util.List;\n" +
                "\n" +
                "@Api(tags = \"" + tableComment + "模块\")\n" +
                "@RequestMapping(\"/api/" + defaultTableName + "\")\n" +
                "@RestController\n" +
                "public class " + tableName + "Controller {\n" +
                "\n" +
                "    private static Logger log = LoggerFactory.getLogger(" + tableName + "Controller.class);\n" +
                "\n" +
                "    @Resource\n" +
                "    private " + tableName + "Service " + defaultTableName + "Service;\n" +
                "\n" +
                "    @ApiOperation(\"分页查询\")\n" +
                "    @PostMapping(value = \"/queryPage\")\n" +
                "    public ResultPage<" + tableName + "> queryPage(@RequestBody " + tableName + " " + defaultTableName + ") {\n" +
                "        log.info(\"" + tableComment + "模块-分页查询，参数" + defaultTableName + "={}\", " + defaultTableName + ");\n" +
                "        Page<" + tableName + "> page = " + defaultTableName + "Service.queryPage(" + defaultTableName + ");\n" +
                "        PageInfo<" + tableName + "> pageInfo = new PageInfo<>(page);\n" +
                "        return new ResultPage<" + tableName + ">(BusinessStatus.SUCCESS_GET, pageInfo);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"查询全部\")\n" +
                "    @GetMapping(value = \"/queryAll\")\n" +
                "    public Result<List<" + tableName + ">> queryAll() {\n" +
                "        log.info(\"" + tableComment + "模块-查询全部，参数" + defaultTableName + "={}\");\n" +
                "        List<" + tableName + "> list = " + defaultTableName + "Service.queryAll();\n" +
                "        return new Result<List<" + tableName + ">>(BusinessStatus.SUCCESS_GET, list);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"查询单条记录\")\n" +
                "    @GetMapping(value = \"/queryOne\")\n" +
                "    public Result<" + tableName + "> queryOne(@RequestParam String uuid) {\n" +
                "        log.info(\"" + tableComment + "模块-查询单条记录，参数uuid={}\", uuid);\n" +
                "        " + tableName + " one = " + defaultTableName + "Service.queryOne(uuid);\n" +
                "        return new Result<" + tableName + ">(BusinessStatus.SUCCESS_GET, one);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"新增\")\n" +
                "    @PostMapping(value = \"/save\")\n" +
                "    public Result<" + tableName + "> insert(@RequestBody " + tableName + " " + defaultTableName + ") {\n" +
                "        log.info(\"" + tableComment + "模块-新增，参数" + defaultTableName + "={}\", " + defaultTableName + ");\n" +
                "        " + defaultTableName + "Service.insert(" + defaultTableName + ");\n" +
                "        return new Result<>(BusinessStatus.SUCCESS_ADD);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"修改\")\n" +
                "    @PutMapping(value = \"/update\")\n" +
                "    public Result<" + tableName + "> update(@RequestBody " + tableName + " " + defaultTableName + ") {\n" +
                "        log.info(\"" + tableComment + "模块-修改，参数" + defaultTableName + "={}\", " + defaultTableName + ");\n" +
                "        " + defaultTableName + "Service.update(" + defaultTableName + ");\n" +
                "        return new Result<>(BusinessStatus.SUCCESS_UPDATE);\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(\"删除\")\n" +
                "    @DeleteMapping(value = \"/delete\")\n" +
                "    public Result<" + tableName + "> delete(@RequestParam String uuid) {\n" +
                "        log.info(\"" + tableComment + "模块-删除，参数uuid={}\", uuid);\n" +
                "        " + defaultTableName + "Service.delete(uuid);\n" +
                "        return new Result<>(BusinessStatus.SUCCESS_DELETE);\n" +
                "    }\n" +
                "\n" +
                "}\n";
    }
}
