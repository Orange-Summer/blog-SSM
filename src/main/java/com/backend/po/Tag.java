package com.backend.po;

import com.backend.vo.TagVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/6
 */
@Data
public class Tag {

    private Long id;

    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public Tag() {
    }

    public Tag(TagVo tagVo) {
        id = tagVo.getId();
        name = tagVo.getName();
        blogs = tagVo.getBlogs();
    }
}
