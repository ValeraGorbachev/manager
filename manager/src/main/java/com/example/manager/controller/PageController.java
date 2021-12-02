package com.example.manager.controller;

import com.example.manager.entity.Page;
import com.example.manager.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/pages")
    public String findAll(Model model) {
        List<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);
        return "page-list";
    }

    @GetMapping("/page-create")
    public String createPageForm(Page page) {
        return "page-create";
    }

    @PostMapping("/page-create")
    public String createPage(Page page){
        pageService.savePage(page);
        return "redirect:/pages";
    }
    @GetMapping("/page-delete/{id}")
    public String deletePage(@PathVariable("id") Integer id){
    pageService.deleteById(id);
    return "redirect:/pages";
    }

    @GetMapping("/page-update/{id}")
    public String updatePageForm(@PathVariable("id")Integer id, Model model){
       Page page=pageService.findById(id);
       model.addAttribute("page",page);
        return "/page-update";
    }
    @PostMapping("/page-update")
    public String updatePage(Page page){
        pageService.savePage(page);
        return "redirect:/pages";
    }


}
