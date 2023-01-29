package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backends.stock.entity.Linventaire;

public interface LinventaireRepository  extends JpaRepository<Linventaire, Long> {

}
