package com.pg.generate.service;

import com.pg.generate.dto.GenTableInfo;

public interface GenService {

    /**
     * 生成实体信息
     * @param genTableInfo
     */
    int GenEntity(GenTableInfo genTableInfo);
}
