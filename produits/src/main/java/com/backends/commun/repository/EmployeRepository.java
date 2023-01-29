package com.backends.commun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.backends.commun.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{

}
