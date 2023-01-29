package com.backends.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.backends.reclamation.entity.Infraction;


@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction, Long> {

}
