package com.backend.serviceimpl;

import com.backend.mapperservice.TypeMapper;
import com.backend.po.Type;
import com.backend.service.TypeService;
import com.backend.util.Constant;
import com.backend.util.PageInfoUtil;
import com.backend.vo.ResultVO;
import com.backend.vo.TypeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public ResultVO<TypeVo> saveType(TypeVo typeVo) {
        List<Type> res = typeMapper.queryByName(typeVo.getName());
        if (res.size() != 0) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "已存在同名分类");
        }
        Type type = new Type(typeVo);
        if (typeMapper.saveType(type) > 0) {
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "分类创建成功", new TypeVo(type));
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    @Override
    public TypeVo getType(Long id) {
        Type type = typeMapper.queryById(id);
        return new TypeVo(type);
    }

    @Override
    public PageInfo<TypeVo> listType(Integer currPage, Integer pageSize) {
        if (currPage == null || currPage < 1) currPage = 1;
        PageHelper.startPage(currPage, pageSize);
        PageInfo<Type> po = new PageInfo<>(typeMapper.queryAll());
        return getTypeVOPageInfo(po);
    }

    @Override
    public List<TypeVo> listType() {
        List<Type> types = typeMapper.queryAll();
        List<TypeVo> typeVos = new ArrayList<>();
        for (Type a : types) {
            typeVos.add(new TypeVo(a));
        }
        return typeVos;
    }

    @Override
    public ResultVO<TypeVo> updateType(TypeVo typeVo) {
        Type a = typeMapper.queryById(typeVo.getId());
        if (a == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "分类不存在");
        }
        List<Type> res = typeMapper.queryByName(typeVo.getName());
        if (res.size() != 0) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "已存在同名分类");
        }
        Type type = new Type(typeVo);
        if (typeMapper.updateType(type) > 0) {
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "分类更新成功", new TypeVo(type));
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    @Override
    public ResultVO<TypeVo> deleteType(Long id) {
        if (typeMapper.deleteType(id) > 0) {
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "分类删除成功");
        }
        return new ResultVO<>(Constant.REQUEST_FAIL, "服务器错误");
    }

    private PageInfo<TypeVo> getTypeVOPageInfo(PageInfo<Type> po) {
        return PageInfoUtil.convert(po, TypeVo.class);
    }


}
