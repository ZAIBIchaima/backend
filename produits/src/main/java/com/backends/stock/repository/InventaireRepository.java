package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backends.stock.entity.Inventaire;



public interface InventaireRepository extends JpaRepository<Inventaire, Long> {

}
