package com.backends.commun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.commun.entity.Departement;



@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
