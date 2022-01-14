package com.backend.po;

import com.backend.vo.SearchBlogVo;
import lombok.Data;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/17
 */
@Data
public class SearchBlog {

    private String title;

    private String tids;

    private Boolean recommend;

    private Integer currPage;

    public SearchBlog() {

    }

    public SearchBlog(SearchBlogVo searchBlogVo) {
        title = searchBlogVo.getTitle();
        tids = searchBlogVo.getTids();
        recommend = searchBlogVo.getRecommend();
        currPage = searchBlogVo.getCurrPage();
    }
}
