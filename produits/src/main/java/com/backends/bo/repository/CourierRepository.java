package com.backends.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.bo.entity.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

}
