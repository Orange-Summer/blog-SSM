package com.backend.vo;

import com.backend.po.Blog;
import com.backend.po.Comment;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Data
public class CommentVo {

    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date createTime;

    private Blog blog;

    private List<Comment> replyComment = new ArrayList<>();

    private Comment parentComment;

    public CommentVo(){};

    public CommentVo(@NonNull Comment comment){
        id = comment.getId();
        nickname = comment.getNickname();
        email = comment.getEmail();
        content = comment.getContent();
        avatar = comment.getAvatar();
        createTime = comment.getCreateTime();
        blog = comment.getBlog();
        replyComment = comment.getReplyComment();
        parentComment = comment.getParentComment();
    }
}
