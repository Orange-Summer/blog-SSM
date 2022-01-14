package com.backend.controller;

import com.backend.service.BlogService;
import com.backend.service.TypeService;
import com.backend.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/4
 */
@Controller
public class IndexController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) Integer currPage) {
        model.addAttribute("pageInfo", blogService.listBlog(Constant.Blog_PAGE_SIZE, currPage));
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String query, @RequestParam(required = false) Integer currPage) {
        model.addAttribute("pageInfo", blogService.listBlog(Constant.Blog_PAGE_SIZE, currPage, query));
        model.addAttribute("query", query);
        return "search";
    }

}
