package com.backends.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.stock.entity.Operation;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

}