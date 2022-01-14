package com.backend.po;

import com.backend.vo.BlogVo;
import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/6
 */
@Data
public class Blog {

    private Long id;

    private String title;

    private String description;

    private String content;

    private String firstPicture;

    private String flag;

    private Integer views;

    private Boolean appreciation;

    private Boolean shareStatement;

    private Boolean commentabled;

    private Boolean published;

    private Boolean recommend;

    private Date createTime;

    private Date updateTime;

    private Long uid;

    private String type;

    private String tids;

    public Blog() {
    }


    public Blog(BlogVo blogVo) {
        id = blogVo.getId();
        title = blogVo.getTitle();
        description = blogVo.getDescription();
        content = blogVo.getContent();
        firstPicture = blogVo.getFirstPicture();
        flag = blogVo.getFlag();
        views = blogVo.getViews();
        appreciation = blogVo.getAppreciation();
        shareStatement = blogVo.getShareStatement();
        commentabled = blogVo.getCommentabled();
        published = blogVo.getPublished();
        recommend = blogVo.getRecommend();
        createTime = blogVo.getCreateTime();
        updateTime = blogVo.getUpdateTime();
        uid = blogVo.getUid();
        type = blogVo.getType();
        tids = blogVo.getTids();
    }
}
