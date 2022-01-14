package com.backend.vo;

import com.backend.po.Blog;
import com.backend.po.Tag;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Data
public class TagVo {

    private Long id;

    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public TagVo() {
    }

    public TagVo(@NonNull Tag tag) {
        id = tag.getId();
        name = tag.getName();
        blogs = tag.getBlogs();
    }
}
