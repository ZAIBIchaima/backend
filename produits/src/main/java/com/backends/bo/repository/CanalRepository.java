package com.backends.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.bo.entity.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Long>{

}
