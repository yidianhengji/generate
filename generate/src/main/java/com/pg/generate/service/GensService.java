package com.pg.generate.service;

import com.pg.generate.dto.GenTableInfo;

public interface GensService {

    /**
     * 生成实体信息
     * @param genTableInfo
     */
    int GenTemplate(GenTableInfo genTableInfo);
}
