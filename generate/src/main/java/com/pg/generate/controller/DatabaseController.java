package com.pg.generate.controller;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Column;
import com.pg.generate.entity.Database;
import com.pg.generate.entity.Projects;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.PageInfo;
import com.pg.generate.handler.Result;
import com.pg.generate.handler.ResultPage;
import com.pg.generate.service.ColumnService;
import com.pg.generate.service.DatabaseService;
import com.pg.generate.service.ProjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "数据库模块")
@RequestMapping("/api/database")
@RestController
public class DatabaseController {

    private static Logger log = LoggerFactory.getLogger(DatabaseController.class);

    @Resource
    private DatabaseService databaseService;

    @Resource
    private ProjectsService projectsService;

    @Resource
    private ColumnService columnService;

    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResultPage<Database> queryPage(@RequestBody Database database) {
        log.info("活动模块-分页查询，参数database={}", database);
        Page<Database> page = databaseService.queryPage(database);
        PageInfo<Database> pageInfo = new PageInfo<Database>(page);
        return new ResultPage<Database>(BusinessStatus.SUCCESS_GET, pageInfo);
    }

    @ApiOperation("查询全部")
    @GetMapping(value = "/queryAll")
    public Result<List<Database>> queryAll(String projectId) {
        log.info("活动模块-查询全部，参数database={}");
        List<Database> list = databaseService.queryAll(projectId);
        return new Result<List<Database>>(BusinessStatus.SUCCESS_GET, list);
    }

    @ApiOperation("查询单条记录")
    @GetMapping(value = "/queryOne")
    public Result<Database> queryOne(@RequestParam String tableId) {
        log.info("活动模块-查询单条记录，参数tableId={}", tableId);
        Database one = databaseService.queryOne(tableId);
        return new Result<Database>(BusinessStatus.SUCCESS_GET, one);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/save")
    public Result<Database> insert(@RequestBody Database database) {
        log.info("活动模块-新增，参数database={}", database);
        databaseService.insert(database);
        return new Result<Database>(BusinessStatus.SUCCESS_ADD);
    }

    @ApiOperation("修改")
    @PutMapping(value = "/update")
    public Result<Database> update(@RequestBody Database database) {
        log.info("活动模块-修改，参数database={}", database);
        databaseService.update(database);
        return new Result<Database>(BusinessStatus.SUCCESS_UPDATE);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public Result<Database> delete(@RequestParam String tableId) {
        log.info("活动模块-删除，参数tableId={}", tableId);
        databaseService.delete(tableId);
        return new Result<Database>(BusinessStatus.SUCCESS_DELETE);
    }

    @ApiOperation("根据项目id查询数据库的表")
    @GetMapping(value = "/getUpdateDataTable")
    public Result<List<Database>> getUpdateDataTable(@RequestParam String projectId) {
        // 根据项目id查询项目的记录
        Projects one = projectsService.queryOne(projectId);
        // 根据数据库名称查询 该数据库下面的全部表
        databaseService.deleteProject(projectId);
        List<Database> databasesList = databaseService.queryTableAll(one.getDatabaseName());
        if(databasesList.size()>0){
            for (Database item : databasesList) {
                item.setProjectId(projectId);
                databaseService.insert(item);
            }
        }
        // 查询全部的表
        List<Database> queryAll = databaseService.queryAll(projectId);
        if(queryAll.size()>0){
            // 查询出来的表进行遍历
            for(Database item : queryAll){
                // 查询出表里面的字段
                List<Column> columns = columnService.queryTableColumnAll(item.getTableSchema(), item.getTableName());
                if(columns.size()>0){
                    // 把表里面的字段进行遍历
                    for(Column items : columns) {
                        items.setTableId(item.getTableId());
                        columnService.insert(items);
                    }
                }
            }
        }

        return new Result<>(BusinessStatus.SUCCESS);
    }

}
