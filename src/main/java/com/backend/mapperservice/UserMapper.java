package com.backend.mapperservice;

import com.backend.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/8
 */
@Mapper
public interface UserMapper {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
