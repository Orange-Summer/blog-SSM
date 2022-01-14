package com.backend.vo;

import com.backend.po.Blog;
import com.backend.po.Type;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Data
public class TypeVo {

    private Long id;

    @NotBlank(message = "请输入分类名称")
    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public TypeVo() {

    }

    public TypeVo(@NonNull Type type) {
        id = type.getId();
        name = type.getName();
        blogs = type.getBlogs();
    }
}
