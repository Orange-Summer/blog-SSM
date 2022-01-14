package com.backend.controller.admin;

import com.backend.service.BlogService;
import com.backend.service.TypeService;
import com.backend.util.Constant;
import com.backend.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/9
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(Model model, SearchBlogVo searchBlogVo) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("pageInfo", blogService.listBlog(Constant.Blog_PAGE_SIZE, searchBlogVo));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(Model model, SearchBlogVo searchBlogVo) {
        model.addAttribute("pageInfo", blogService.listBlog(Constant.Blog_PAGE_SIZE, searchBlogVo));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("blogVo", new BlogVo());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/save")
    public String post(@Valid BlogVo blogVo, BindingResult result, RedirectAttributes attributes, HttpSession session) {
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        blogVo.setUid(((UserVo) session.getAttribute("user")).getId());
        ResultVO<BlogVo> resultVO = blogService.saveBlog(blogVo);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs/input";
        }
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("blogVo", blogService.getBlog(id));
        return "admin/blogs-input";
    }

    @PostMapping("blogs/update")
    public String editPost(@Valid BlogVo blogVo, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/blogs-input";
        }
        ResultVO<BlogVo> resultVO = blogService.updateBlog(blogVo);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs/input";
        }
    }

    @GetMapping("blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        ResultVO<BlogVo> resultVO = blogService.deleteBlog(id);
        if (Objects.equals(resultVO.getCode(), Constant.REQUEST_SUCCESS)) {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs";
        } else {
            attributes.addFlashAttribute("result", resultVO);
            return "redirect:/admin/blogs/input";
        }
    }
}
