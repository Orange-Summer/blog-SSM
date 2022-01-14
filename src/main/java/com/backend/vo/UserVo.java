package com.backend.vo;

import com.backend.po.Blog;
import com.backend.po.User;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Data
public class UserVo {

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

    public UserVo() {

    }

    public UserVo(@NonNull User user) {
        id = user.getId();
        nickname = user.getNickname();
        username = user.getUsername();
        password = user.getPassword();
        email = user.getEmail();
        avatar = user.getAvatar();
        type = user.getType();
        createTime = user.getCreateTime();
        updateTime = user.getUpdateTime();
        blogs = user.getBlogs();
    }
}
