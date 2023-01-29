package com.backends.stock.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
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

import javax.servlet.ServletContext;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.backends.exception.ResourceNotFoundException;
import com.backends.stock.entity.DetailsOperation;
import com.backends.stock.entity.Entre;
import com.backends.stock.entity.Sortie;
import com.backends.stock.repository.DetailsOperationRepository;
import com.backends.stock.repository.EntreRepository;
import com.backends.stock.repository.SortieRepository;



@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK') ")
public class EntreController  {
	@Autowired 	EntreRepository repository;
	@Autowired DetailsOperationRepository repo;
	
	@Autowired  ServletContext context;
	
	 @GetMapping("/entres")
	  public List<Entre> getAllEntres() {
	    System.out.println("Get all Entres...");
	    List<Entre> entres = new ArrayList<>();
	    repository.findAll().forEach(entres::add);
	    return entres;
	  }
	
	@GetMapping("/entres/{id}")
	public ResponseEntity<Entre> getEntreById(@PathVariable(value = "id") Long EntreId)
			throws ResourceNotFoundException {
		Entre entre = repository.findById(EntreId)
		
				.orElseThrow(() -> new ResourceNotFoundException("Entre not found for this id :: " + EntreId));
		return ResponseEntity.ok().body(entre);
	}
	
	 @PostMapping("/entres")
	 public Entre createEntre( @RequestBody Entre entre) {
		 return repository.save(entre);
	 }

	@DeleteMapping("/entres/{id}")
	public ResponseEntity<Entre>deleteEntre(@PathVariable(value = "id") Long OppId)
	{
		Optional<Entre> OppInfo = repository.findById(OppId);
	  if (OppInfo.isPresent()) {
		  System.out.println("Entre 11");
		  Entre Entre = OppInfo.get();
		  repo.deleteById(Entre.getId());
		  repository.delete(Entre);
		  return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	  @DeleteMapping("/entres/delete")
	  public ResponseEntity<String> deleteAllEntres() {
	    System.out.println("Delete All Entres...");
	    repository.deleteAll();
	    return new ResponseEntity<>("All Entres have been deleted!", HttpStatus.OK);
	  }
	 
	  @PutMapping("/entres/{id}")
	  public ResponseEntity<Entre> updateEntre(@PathVariable("id") long id, @RequestBody Entre Entre) {
	    System.out.println("Update Entre with ID = " + id + "...");
	    Optional<Entre> EntreInfo = repository.findById(id);
	    if (EntreInfo.isPresent()) {
	    	Entre entre = EntreInfo.get();
	    	Entre.setId(Entre.getId());
	    	Entre.setDateOperation(Entre.getDateOperation());
	    	Entre.setRefOperation(Entre.getRefOperation());
	    	Entre.setNumeroOperation(Entre.getNumeroOperation());
	    	Entre.setIdF(Entre.getIdF());
	    	Entre.setNomF(Entre.getNomF());
	    	
	    	
	      return new ResponseEntity<>(repository.save(entre), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }}