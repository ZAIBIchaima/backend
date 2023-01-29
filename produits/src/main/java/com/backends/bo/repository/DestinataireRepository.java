package com.backends.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backends.bo.entity.Destinataire;


@Repository
public interface DestinataireRepository  extends JpaRepository<Destinataire, Long>{

}
