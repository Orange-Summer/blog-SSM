package com.backend.controller.admin;

import com.backend.service.TypeService;
import com.backend.util.Constant;
import com.backend.vo.ResultVO;
import com.backend.vo.TypeVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/11
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Resource
    private TypeService typeService;

    /**
     * 分类列表
     *
     * @param model
     * @param currPage
     * @return
     */
    @GetMapping("/types")
    public String types(Model model, @RequestParam(required = false) Integer currPage) {
        model.addAttribute("pageInfo", typeService.listType(currPage, Constant.Type_PAGE_SIZE));
        return "admin/types";
    }

    /**
     * 跳转到分类发布页
     *
     * @param model
     * @return
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("typeVo", new TypeVo());
        return "admin/types-input";
    }

    /**
     * 创建新分类
     *
     * @param typeVo
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("/types/save")
    public String post(@Valid TypeVo typeVo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        ResultVO<TypeVo> resultVO = typeService.saveType(typeVo);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types/input";
        }
    }

    /**
     * 跳转至编辑界面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("typeVo", typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * 更新分类
     *
     * @param typeVo
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("types/{id}/update")
    public String editPost(@Valid TypeVo typeVo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        ResultVO<TypeVo> resultVO = typeService.updateType(typeVo);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types/input";
        }
    }

    /**
     * 删除分类
     *
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        ResultVO<TypeVo> resultVO = typeService.deleteType(id);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/types/input";
        }
    }

}
