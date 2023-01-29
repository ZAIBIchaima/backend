package com.backends.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.bo.entity.Recus;

@Repository
public interface RecusRepository extends JpaRepository<Recus, Long> {

}
