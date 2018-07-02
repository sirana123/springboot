package com.khoubyari.example.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.khoubyari.example.domain.BookGround;

public interface GroundRepository extends PagingAndSortingRepository<BookGround, Long> {
    BookGround findGroundByLocation(String location);
    Page findAll(Pageable pageable);
}
