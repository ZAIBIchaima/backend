package com.backends.stock.web;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import com.backends.exception.ResourceNotFoundException;
import com.backends.stock.entity.Operation;
import com.backends.stock.entity.Sortie;
import com.backends.stock.repository.SortieRepository;

@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK') ")
public class SortieController  {
	@Autowired 	SortieRepository  repository;
	
	 @GetMapping("/sorties")
	  public List<Sortie> getAllSorties() {
	     System.out.println("Get all Sortie...");
	 
	    List<Sortie> sorties = new ArrayList<>();
	    repository.findAll().forEach(sorties::add);
	 
	    return sorties;
	  }
	 
	 @GetMapping("/sorties/{id}")
		public ResponseEntity<Sortie> getSortieById(@PathVariable(value = "id") Long Id)
				throws ResourceNotFoundException {
		 Sortie Sortie = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Sortie not found for this id :: " + Id));
			return ResponseEntity.ok().body(Sortie);
		}
	 
	
	 @PostMapping("/sorties")
	 public Sortie createSortie( @RequestBody Sortie sortie) {
		 return repository.save(sortie);
	 }
	 

	 @DeleteMapping("/sorties/{id}")
		public Map<String,Boolean>deleteSortie(@PathVariable(value="id")Long SortieId)
				throws ResourceNotFoundException {
		 Sortie Sortie = repository.findById(SortieId).orElseThrow(() -> new ResourceNotFoundException("Sortie not found for this id :: " + SortieId));
			repository.delete(Sortie);
			Map<String,Boolean>response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		
	}
	 @DeleteMapping("/sorties/delete")
		public ResponseEntity<String>deleteAllSorties(){
			System.out.println("Delete All sorties");
			repository.deleteAll();
			return new ResponseEntity<>("All sorties have been deleted!",HttpStatus.OK);
		}

	  @PutMapping("/sorties/{id}")
	  public ResponseEntity<Sortie> updateArticle(@PathVariable("id") long id, @RequestBody Sortie Sortie) {
	    System.out.println("Update Sortie with ID = " + id + "...");
	    Optional<Sortie> SortieInfo = repository.findById(id);
	    if (SortieInfo.isPresent()) {
	    	Sortie sortie = SortieInfo.get();
	     sortie.setNumeroOperation(Sortie.getNumeroOperation());
	     sortie.setDateOperation(Sortie.getDateOperation());
	     sortie.setRefOperation(Sortie.getRefOperation());
	     sortie.setIdDep(Sortie.getIdDep())	 ;    
	     sortie.setLibDep(Sortie.getLibDep())	 ;    
  
	  
	     
	           
	          
	      return new ResponseEntity<>(repository.save(Sortie), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}