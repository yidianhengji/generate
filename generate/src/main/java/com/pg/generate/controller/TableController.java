package com.pg.generate.controller;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Table;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.PageInfo;
import com.pg.generate.handler.Result;
import com.pg.generate.handler.ResultPage;
import com.pg.generate.service.TableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "活动模块")
@RequestMapping("/api/table")
@RestController
public class TableController {

    private static Logger log = LoggerFactory.getLogger(TableController.class);

    @Resource
    private TableService tableService;

    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResultPage<Table> queryPage(@RequestBody Table table) {
        log.info("活动模块-分页查询，参数table={}", table);
        Page<Table> page = tableService.queryPage(table);
        PageInfo<Table> pageInfo = new PageInfo<Table>(page);
        return new ResultPage<Table>(BusinessStatus.SUCCESS_GET, pageInfo);
    }

    @ApiOperation("查询全部")
    @GetMapping(value = "/queryAll")
    public Result<List<Table>> queryAll() {
        log.info("活动模块-查询全部，参数table={}");
        List<Table> list = tableService.queryAll();
        return new Result<List<Table>>(BusinessStatus.SUCCESS_GET, list);
    }

    @ApiOperation("查询单条记录")
    @GetMapping(value = "/queryOne")
    public Result<Table> queryOne(@RequestParam String tableId) {
        log.info("活动模块-查询单条记录，参数tableId={}", tableId);
        Table one = tableService.queryOne(tableId);
        return new Result<Table>(BusinessStatus.SUCCESS_GET, one);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/save")
    public Result<Table> insert(@RequestBody Table table) {
        log.info("活动模块-新增，参数table={}", table);
        tableService.insert(table);
        return new Result<Table>(BusinessStatus.SUCCESS_ADD);
    }

    @ApiOperation("修改")
    @PutMapping(value = "/update")
    public Result<Table> update(@RequestBody Table table) {
        log.info("活动模块-修改，参数table={}", table);
        tableService.update(table);
        return new Result<Table>(BusinessStatus.SUCCESS_UPDATE);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public Result<Table> delete(@RequestParam String tableId) {
        log.info("活动模块-删除，参数tableId={}", tableId);
        tableService.delete(tableId);
        return new Result<Table>(BusinessStatus.SUCCESS_DELETE);
    }

}
