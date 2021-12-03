package com.example.manager.service;

import com.example.manager.Repository.PageRepository;
import com.example.manager.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PageService {

    @Autowired
    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Page findById(Integer id) {
        return pageRepository.findById(id)
        .orElseThrow(() -> new ExpressionException("error"));

    }

    public List<Page> findAll(Integer pageNo, Integer pageSize, String sortBy){
          Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        org.springframework.data.domain.Page<Page> pagedResult = pageRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Page>();
        }
    }

    public Page savePage(Page page){
        return pageRepository.save(page);
    }
    public void deleteById(Integer id){
        pageRepository.deleteById(id);
    }
}
