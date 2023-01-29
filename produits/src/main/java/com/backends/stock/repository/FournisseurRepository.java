package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}