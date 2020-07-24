package com.pg.generate.controller;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Column;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.PageInfo;
import com.pg.generate.handler.Result;
import com.pg.generate.handler.ResultPage;
import com.pg.generate.service.ColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Api(tags = "活动模块")
@RequestMapping("/api/column")
@RestController
public class ColumnController {

    private static Logger log = LoggerFactory.getLogger(ColumnController.class);

    @Autowired
    private ColumnService columnService;

    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResultPage<Column> queryPage(@RequestBody Column column) {
        log.info("活动模块-分页查询，参数column={}", column);
        Page<Column> page = columnService.queryPage(column);
        PageInfo<Column> pageInfo = new PageInfo<Column>(page);
        return new ResultPage<Column>(BusinessStatus.SUCCESS_GET, pageInfo);
    }

    @ApiOperation("查询全部")
    @GetMapping(value = "/queryAll")
    public Result<List<Column>> queryAll() {
        log.info("活动模块-查询全部，参数column={}");
        List<Column> list = columnService.queryAll();
        return new Result<List<Column>>(BusinessStatus.SUCCESS_GET, list);
    }

    @ApiOperation("查询单条记录")
    @GetMapping(value = "/queryOne")
    public Result<Column> queryOne(@RequestParam String columnId) {
        log.info("活动模块-查询单条记录，参数columnId={}", columnId);
        Column one = columnService.queryOne(columnId);
        return new Result<Column>(BusinessStatus.SUCCESS_GET, one);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/save")
    public Result<Column> insert(@RequestBody Column column) {
        log.info("活动模块-新增，参数column={}", column);
        columnService.insert(column);
        return new Result<Column>(BusinessStatus.SUCCESS_ADD);
    }

    @ApiOperation("修改")
    @PutMapping(value = "/update")
    public Result<Column> update(@RequestBody Column column) {
        log.info("活动模块-修改，参数column={}", column);
        columnService.update(column);
        return new Result<Column>(BusinessStatus.SUCCESS_UPDATE);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public Result<Column> delete(@RequestParam String columnId) {
        log.info("活动模块-删除，参数columnId={}", columnId);
        columnService.delete(columnId);
        return new Result<Column>(BusinessStatus.SUCCESS_DELETE);
    }

}
