package com.pg.generate.service;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Projects;

import java.util.List;

public interface ProjectsService {

    Page<Projects> queryPage(Projects projects);

    List<Projects> queryAll();

    Projects queryOne(String projectId);

    int insert(Projects projects);

    int update(Projects projects);

    int delete(String projectId);

}
