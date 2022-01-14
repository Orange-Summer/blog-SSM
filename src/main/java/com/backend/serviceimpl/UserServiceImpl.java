package com.backend.serviceimpl;

import com.backend.mapperservice.UserMapper;
import com.backend.po.User;
import com.backend.service.UserService;
import com.backend.util.MD5Utils;
import com.backend.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVo checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
        if (user == null) {
            return null;
        }
        return new UserVo(user);
    }
}
