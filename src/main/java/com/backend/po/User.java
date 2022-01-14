package com.backend.po;

import com.backend.vo.UserVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/6
 */
@Data
public class User {

    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private List<Blog> blogs;

    public User() {

    }

    public User(UserVo userVo) {
        id = userVo.getId();
        nickname = userVo.getNickname();
        username = userVo.getUsername();
        password = userVo.getPassword();
        email = userVo.getEmail();
        avatar = userVo.getAvatar();
        type = userVo.getType();
        createTime = userVo.getCreateTime();
        updateTime = userVo.getUpdateTime();
        blogs = userVo.getBlogs();
    }
}
