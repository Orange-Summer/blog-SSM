package com.backend.service;

import com.backend.vo.BlogVo;
import com.backend.vo.ResultVO;
import com.backend.vo.SearchBlogVo;
import com.github.pagehelper.PageInfo;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/8
 */
public interface BlogService {

    BlogVo getBlog(Long id);

    PageInfo<BlogVo> listBlog(Integer pageSize, Integer currPage);

    PageInfo<BlogVo> listBlog(Integer pageSize, SearchBlogVo searchBlogVo);

    PageInfo<BlogVo> listBlog(Integer pageSize, Integer currPage, String query);

    ResultVO<BlogVo> saveBlog(BlogVo blogVo);

    ResultVO<BlogVo> updateBlog(BlogVo blogVo);

    ResultVO<BlogVo> deleteBlog(Long id);
}
