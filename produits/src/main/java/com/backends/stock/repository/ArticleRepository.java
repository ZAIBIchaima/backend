package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}