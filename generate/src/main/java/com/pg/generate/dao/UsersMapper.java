package com.pg.generate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pg.generate.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
