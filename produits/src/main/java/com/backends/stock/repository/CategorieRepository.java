package com.backends.stock.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.*;
@Repository
public interface CategorieRepository  extends JpaRepository<Categorie, Long> {
	}

