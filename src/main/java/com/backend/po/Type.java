package com.backend.po;

import com.backend.vo.TypeVo;
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
public class Type {

    private Long id;

    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public Type() {

    }

    public Type(TypeVo typeVo) {
        id = typeVo.getId();
        name = typeVo.getName();
        blogs = typeVo.getBlogs();
    }
}
