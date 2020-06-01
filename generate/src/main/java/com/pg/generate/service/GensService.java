package com.pg.generate.service;

import org.apache.ibatis.annotations.Param;

public interface GensService {

    /**
     * 生成实体信息
     * @param tableSchema
     * @param tableName
     * @return
     */
    int GenTemplate(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
}
