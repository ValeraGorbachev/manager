package com.example.manager.service;

import com.example.manager.Repository.PageRepository;
import com.example.manager.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PageService {

    @Autowired
    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Page findById(Integer id) {
        return pageRepository.getById(id);
    }

    public List<Page> findAll(){
        return pageRepository.findAll();
    }

    public Page savePage(Page page){
        return pageRepository.save(page);
    }
    public void deleteById(Integer id){
        pageRepository.deleteById(id);
    }
}
