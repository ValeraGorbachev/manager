package com.example.manager.controller;

import com.example.manager.entity.Page;
import com.example.manager.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @RequestMapping("/menu")
    public String getHomepage() {
        return "menu_label";
    }

    @GetMapping("/pages")
    public String findAll(Model model, @RequestParam(defaultValue = "0") Integer pageNo,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "id") String sortBy) {
            List<Page> pages = pageService.findAll(pageNo, pageSize, "priority");
            model.addAttribute("pages", pages);
        return "content";
    }

    @GetMapping("/page-create")
    public String createPageForm(Page page) {
        return "page-create";
    }

    @PostMapping("/page-create")
    public String createPage(Page page) {
        pageService.savePage(page);
        return "redirect:/pages";
    }

    @GetMapping("/page-delete/{id}")
    public String deletePage(@PathVariable("id") Integer id) {
        pageService.deleteById(id);
        return "redirect:/pages";
    }

    @GetMapping("/page-update/{id}")
    public String updatePageForm(@PathVariable("id") Integer id, Model model) {
        Page page = pageService.findById(id);
        model.addAttribute("page", page);
        return "/page-update";
    }

    @PostMapping("/page-update")
    public String updatePage(Page page) {
        pageService.savePage(page);
        return "redirect:/pages";
    }
    @GetMapping("/page-view/{id}")
    public String findPageById(Page page, @PathVariable Integer id){
        pageService.findById(id);
        return "/page-view";

    }
}
