package com.backend.serviceimpl;

import com.backend.mapperservice.BlogMapper;
import com.backend.po.Blog;
import com.backend.po.SearchBlog;
import com.backend.service.BlogService;
import com.backend.util.Constant;
import com.backend.util.PageInfoUtil;
import com.backend.vo.BlogVo;
import com.backend.vo.ResultVO;
import com.backend.vo.SearchBlogVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/14
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;


    @Override
    public BlogVo getBlog(Long id) {
        Blog blog = blogMapper.queryById(id);
        return new BlogVo(blog);
    }

    @Override
    public PageInfo<BlogVo> listBlog(Integer pageSize, Integer currPage) {
        if (currPage == null || currPage < 1) currPage = 1;
        PageHelper.startPage(currPage, pageSize);
        PageInfo<Blog> po = new PageInfo<>(blogMapper.queryAll());
        return getBlogVoPageInfo(po);
    }

    @Override
    public PageInfo<BlogVo> listBlog(Integer pageSize, SearchBlogVo searchBlogVo) {
        Integer currPage = searchBlogVo.getCurrPage();
        if (currPage == null || currPage < 1) currPage = 1;
        SearchBlog searchBlog = new SearchBlog(searchBlogVo);
        PageHelper.startPage(currPage, pageSize);
        PageInfo<Blog> po = new PageInfo<>(blogMapper.queryByTitleOrTypeOrRecommend(searchBlog));
        return getBlogVoPageInfo(po);
    }

    @Override
    public PageInfo<BlogVo> listBlog(Integer pageSize, Integer currPage, String query) {
        if (currPage == null || currPage < 1) currPage = 1;
        PageHelper.startPage(currPage, pageSize);
        PageInfo<Blog> po = new PageInfo<>(blogMapper.queryByTitleOrContent(query));
        return getBlogVoPageInfo(po);
    }

    @Override
    public ResultVO<BlogVo> saveBlog(BlogVo blogVo) {
        List<Blog> res = blogMapper.queryByTitle(blogVo.getTitle());
        if (res.size() != 0) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "已存在同名博客");
        }
        Blog blog = new Blog(blogVo);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        if (blogMapper.saveBlog(blog) > 0) {
            if (blogMapper.saveBidAndTid(blog.getId(), blog.getTids()) > 0) {
                return new ResultVO<>(Constant.REQUEST_SUCCESS, "博客创建成功", new BlogVo(blog));
            }
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    @Override
    public ResultVO<BlogVo> updateBlog(BlogVo blogVo) {
        Blog a = blogMapper.queryById(blogVo.getId());
        if (a == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "博客不存在");
        }
        Blog blog = new Blog(blogVo);
        blog.setUpdateTime(new Date());
        if (blogMapper.updateBlog(blog) > 0) {
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "博客更新成功", new BlogVo(blog));
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    @Override
    public ResultVO<BlogVo> deleteBlog(Long id) {
        if (blogMapper.deleteBlog(id) > 0) {
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "博客删除成功");
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    private PageInfo<BlogVo> getBlogVoPageInfo(PageInfo<Blog> po) {
        return PageInfoUtil.convert(po, BlogVo.class);
    }
}
