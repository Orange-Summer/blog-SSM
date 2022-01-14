package com.backend.service;

import com.backend.vo.UserVo;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/8
 */
public interface UserService {

    UserVo checkUser(String username, String password);
}
