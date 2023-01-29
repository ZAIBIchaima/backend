package com.backends.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.bo.entity.Emis;

@Repository
public interface EmitRepository extends JpaRepository<Emis, Long> {

}
