package com.backend.mapperservice;

import com.backend.po.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/10
 */
@Mapper
public interface TypeMapper {
    //新建插入
    int saveType(Type type);
    //通过id查询
    Type queryById(Long id);
    //通过名称查询
    List<Type> queryByName(String name);
    //查询所有
    List<Type> queryAll();
    //更新
    int updateType(Type type);
    //删除
    int deleteType(Long id);
}
