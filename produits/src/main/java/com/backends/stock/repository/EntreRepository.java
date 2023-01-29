package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.Entre;


@Repository
public interface EntreRepository extends JpaRepository<Entre, Long> {

}