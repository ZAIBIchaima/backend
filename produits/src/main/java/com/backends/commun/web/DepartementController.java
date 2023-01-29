package com.backends.commun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backends.commun.entity.Departement;
import com.backends.commun.repository.DepartementRepository;
import com.backends.exception.ResourceNotFoundException;
import com.backends.reclamation.entity.Infraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;



@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('RECLAMATION') or hasRole('ADMIN') or hasRole('STOCK') or hasRole('BO')")
public class DepartementController {
	@Autowired 	DepartementRepository  repository;
	
	 @GetMapping("/departements")
	  public List<Departement> getAllDepartements() {
	     System.out.println("Get all departements...");
	 
	    List<Departement> departements = new ArrayList<>();
	    repository.findAll().forEach(departements::add);
	 
	    return departements;
	  }
	 
	 @GetMapping("/departements/{id}")
		public ResponseEntity<Departement> getDepartementById(@PathVariable(value = "id") Long Id)
				throws ResourceNotFoundException {
		 Departement Departement = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Departement not found for this id :: " + Id));
			return ResponseEntity.ok().body(Departement);
		}
	 
	
	 @PostMapping("/departements")
	 public Departement createDepartement( @RequestBody Departement departement) {
		 return repository.save(departement);
	 }
	 

	 @DeleteMapping("/departements/{id}")
		public Map<String,Boolean>deleteDepartement(@PathVariable(value="id")Long DepartementId)
				throws ResourceNotFoundException {
		 Departement Departement = repository.findById(DepartementId).orElseThrow(() -> new ResourceNotFoundException("Departement not found for this id :: " + DepartementId));
			repository.delete(Departement);
			Map<String,Boolean>response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		
	}
	 @DeleteMapping("/Departements/delete")
		public ResponseEntity<String>deleteAllDepartements(){
			System.out.println("Delete All Departements");
			repository.deleteAll();
			return new ResponseEntity<>("All Departements have been deleted!",HttpStatus.OK);
		}

	  @PutMapping("/departements/{id}")
	  public ResponseEntity<Departement> updateDepartement(@PathVariable("id") long id, @RequestBody Departement Departement) {
	    System.out.println("Update Departement with ID = " + id + "...");
	    Optional<Departement> DepartementInfo = repository.findById(id);
	    if (DepartementInfo.isPresent()) {
	    	Departement departement = DepartementInfo.get();
	    	departement.setLibDep(Departement.getLibDep());
	      return new ResponseEntity<>(repository.save(Departement), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
