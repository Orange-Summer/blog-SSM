package com.backend.po;

import com.backend.vo.CommentVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/6
 */
@Data
public class Comment {

    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date createTime;

    private Blog blog;

    private List<Comment> replyComment = new ArrayList<>();

    private Comment parentComment;

    public Comment(){};

    public Comment(CommentVo commentVo){
        id = commentVo.getId();
        nickname = commentVo.getNickname();
        email = commentVo.getEmail();
        content = commentVo.getContent();
        avatar = commentVo.getAvatar();
        createTime = commentVo.getCreateTime();
        blog = commentVo.getBlog();
        replyComment = commentVo.getReplyComment();
        parentComment = commentVo.getParentComment();
    }
}
