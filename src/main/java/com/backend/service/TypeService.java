package com.backend.service;

import com.backend.vo.ResultVO;
import com.backend.vo.TypeVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
public interface TypeService {
    //新建分类
    ResultVO<TypeVo> saveType(TypeVo typeVo);
    //通过id查询
    TypeVo getType(Long id);
    //分页获取分类列表
    PageInfo<TypeVo> listType(Integer currPage, Integer pageSize);
    //直接获取全部分类
    List<TypeVo> listType();
    //更新分类
    ResultVO<TypeVo> updateType(TypeVo typeVo);
    //删除分类
    ResultVO<TypeVo> deleteType(Long id);
}
