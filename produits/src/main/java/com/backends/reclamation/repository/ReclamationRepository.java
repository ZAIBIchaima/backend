package com.backends.reclamation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.backends.reclamation.entity.Reclamation;


@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	@RestResource(path="/bynum")
	public List<Reclamation> findByNumReclamationContains(@Param("mc") int a);

}
