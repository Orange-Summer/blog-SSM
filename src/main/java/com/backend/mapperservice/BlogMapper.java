package com.backend.mapperservice;

import com.backend.po.Blog;
import com.backend.po.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/14
 */
@Mapper
public interface BlogMapper {
    //新建插入
    int saveBlog(Blog blog);

    //通过id查询
    Blog queryById(Long id);

    //动态查询（标题、分类、推荐）
    List<Blog> queryByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    //动态查询（标题、分类、推荐）
    List<Blog> queryByTitleOrContent(String query);

    //通过名称查询
    List<Blog> queryByTitle(String title);

    //查询所有
    List<Blog> queryAll();

    //更新
    int updateBlog(Blog blog);

    //删除
    int deleteBlog(Long id);

    //插入bid和tid对应
    int saveBidAndTid(@Param("bid") Long bid, @Param("tids") String tids);
}
