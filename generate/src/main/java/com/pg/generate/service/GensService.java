package com.pg.generate.service;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface GensService {

    /**
     * 生成实体信息
     * @param tableSchema
     * @param tableName
     * @return
     */
    HashMap<Object, String> GenTemplate(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName, @Param("type") Integer type);
}
