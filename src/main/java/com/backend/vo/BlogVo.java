package com.backend.vo;

import com.backend.po.Blog;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Data
public class BlogVo {

    private Long id;

    @NotBlank(message = "请输入博客标题")
    private String title;

    @NotBlank(message = "请输入博客描述")
    private String description;

    @NotBlank(message = "请输入博客内容")
    private String content;

    @NotBlank(message = "请输入博客首图地址")
    private String firstPicture;

    private String flag;

    private Integer views;

    private Boolean appreciation = false;

    private Boolean shareStatement = false;

    private Boolean commentabled = false;

    private Boolean published;

    private Boolean recommend = false;

    private Date createTime;

    private Date updateTime;

    private Long uid;

    private String type;

    @NotBlank(message = "请选择博客分类")
    private String tids;

    public BlogVo() {
    }


    public BlogVo(@NonNull Blog blog) {
        id = blog.getId();
        title = blog.getTitle();
        description = blog.getDescription();
        content = blog.getContent();
        firstPicture = blog.getFirstPicture();
        flag = blog.getFlag();
        views = blog.getViews();
        appreciation = blog.getAppreciation();
        shareStatement = blog.getShareStatement();
        commentabled = blog.getCommentabled();
        published = blog.getPublished();
        recommend = blog.getRecommend();
        createTime = blog.getCreateTime();
        updateTime = blog.getUpdateTime();
        uid = blog.getUid();
        type = blog.getType();
        tids = blog.getTids();
    }
}
