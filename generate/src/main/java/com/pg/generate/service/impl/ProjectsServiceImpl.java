package com.pg.generate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.generate.dao.ProjectsMapper;
import com.pg.generate.entity.Projects;
import com.pg.generate.handler.BusinessException;
import com.pg.generate.service.ProjectsService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    private ProjectsMapper projectsMapper;

    @Override
    public Page<Projects> queryPage(Projects projects) {
        if (projects.getPageSize() != null && projects.getPageNum() != null) {
            PageHelper.startPage(projects.getPageNum(), projects.getPageSize());
        }
        Page<Projects> pages = this.projectsMapper.queryPage(projects);
        return pages;
    }

    @Override
    public List<Projects> queryAll() {
        List<Projects> list = this.projectsMapper.queryAll();
        return list;
    }

    @Override
    public Projects queryOne(String projectId) {
        Projects one = this.projectsMapper.queryOne(projectId);
        return one;
    }

    @Override
    public int insert(Projects projects) {
        projects.setProjectId(UUID.randomUUID().toString().replace("-", ""));
        projects.setCreateTime(new Date());
        projects.setModifyTime(new Date());
        return this.projectsMapper.insert(projects);
    }

    @Override
    public int update(Projects projects) {
        if (StringUtil.isEmpty(projects.getProjectId())) {
            throw new BusinessException(500, "project_id必传");
        }
        projects.setModifyTime(new Date());
        return this.projectsMapper.update(projects);
    }

    @Override
    public int delete(String projectId) {
        return this.projectsMapper.delete(projectId);
    }
}
