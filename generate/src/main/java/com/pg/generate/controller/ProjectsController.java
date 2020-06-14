package com.pg.generate.controller;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Projects;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.PageInfo;
import com.pg.generate.handler.Result;
import com.pg.generate.handler.ResultPage;
import com.pg.generate.service.ProjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "活动模块")
@RequestMapping("/api/projects")
@RestController
public class ProjectsController {

    private static Logger log = LoggerFactory.getLogger(ProjectsController.class);

    @Resource
    private ProjectsService projectsService;

    @ApiOperation("分页查询")
    @PostMapping(value = "/queryPage")
    public ResultPage<Projects> queryPage(@RequestBody Projects projects) {
        log.info("活动模块-分页查询，参数projects={}", projects);
        Page<Projects> page = projectsService.queryPage(projects);
        PageInfo<Projects> pageInfo = new PageInfo<Projects>(page);
        return new ResultPage<Projects>(BusinessStatus.SUCCESS_GET, pageInfo);
    }

    @ApiOperation("查询全部")
    @GetMapping(value = "/queryAll")
    public Result<List<Projects>> queryAll() {
        log.info("活动模块-查询全部，参数projects={}");
        List<Projects> list = projectsService.queryAll();
        return new Result<List<Projects>>(BusinessStatus.SUCCESS_GET, list);
    }

    @ApiOperation("查询单条记录")
    @GetMapping(value = "/queryOne")
    public Result<Projects> queryOne(@RequestParam String projectId) {
        log.info("活动模块-查询单条记录，参数projectId={}", projectId);
        Projects one = projectsService.queryOne(projectId);
        return new Result<Projects>(BusinessStatus.SUCCESS_GET, one);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/save")
    public Result<Projects> insert(@RequestBody Projects projects) {
        log.info("活动模块-新增，参数projects={}", projects);
        projectsService.insert(projects);
        return new Result<Projects>(BusinessStatus.SUCCESS_ADD);
    }

    @ApiOperation("修改")
    @PutMapping(value = "/update")
    public Result<Projects> update(@RequestBody Projects projects) {
        log.info("活动模块-修改，参数projects={}", projects);
        projectsService.update(projects);
        return new Result<Projects>(BusinessStatus.SUCCESS_UPDATE);
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/delete")
    public Result<Projects> delete(@RequestParam String projectId) {
        log.info("活动模块-删除，参数projectId={}", projectId);
        projectsService.delete(projectId);
        return new Result<Projects>(BusinessStatus.SUCCESS_DELETE);
    }

}
