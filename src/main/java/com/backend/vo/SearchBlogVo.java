package com.backend.vo;

import com.backend.po.SearchBlog;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/17
 */
@Data
public class SearchBlogVo {

    private String title;

    private String tids;

    private Boolean recommend;

    private Integer currPage;

    public SearchBlogVo() {

    }

    public SearchBlogVo(SearchBlog searchBlog) {
        title = searchBlog.getTitle();
        tids = searchBlog.getTids();
        recommend = searchBlog.getRecommend();
        currPage = searchBlog.getCurrPage();
    }
}
