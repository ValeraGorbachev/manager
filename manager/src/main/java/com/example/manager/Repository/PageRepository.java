package com.example.manager.Repository;

import com.example.manager.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageRepository extends PagingAndSortingRepository<Page,Integer> {
}
