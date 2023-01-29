package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.Sortie;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Long>{

}
