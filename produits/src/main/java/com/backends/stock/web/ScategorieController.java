package com.backends.stock.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import com.backends.exception.ResourceNotFoundException;
import com.backends.stock.entity.Categorie;
import com.backends.stock.entity.Scategorie;
import com.backends.stock.repository.CategorieRepository;
import com.backends.stock.repository.ScategorieRepository;

@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK') ")
public class ScategorieController {
	@Autowired 	ScategorieRepository  repository;
	@Autowired 	CategorieRepository  categorieRepository;

	
	@GetMapping("/scategories")
	  public List<Scategorie> getAllScategories() {
	    System.out.println("Get all Scategories...");
	 
	    List<Scategorie> Scategories = new ArrayList<>();
	    repository.findAll().forEach(Scategories::add);
	 
	    return Scategories;
	  }
	
	 
	 
	 
	 @GetMapping("/scategories/5/{idCat}")
	
	    public ResponseEntity<List<Scategorie>> listCateg(@PathVariable long idCat) {
	        
			List<Scategorie> scategories = repository.findByCateg(idCat);
	       
	        return new ResponseEntity<List<Scategorie>>(scategories, HttpStatus.OK);
	    }
	 
	 
	 
	 
	 
	 
	@GetMapping("/scategories/{idCat}")
	public ResponseEntity<Scategorie> getScategorieByCode(@PathVariable long idCat)
			throws ResourceNotFoundException {
		Scategorie Scategorie = repository.findById(idCat)
				.orElseThrow(() -> new ResourceNotFoundException("Scategorie not found for this id :: " + idCat));
		return ResponseEntity.ok().body(Scategorie);
	}

	
	@PostMapping("/scategories")
	public Scategorie createsCategorie( @RequestBody Scategorie sCategorie) {
		Optional<Categorie> categoryParent= categorieRepository.findById(sCategorie.getIdCat());
		if (categoryParent.isPresent()){
			sCategorie.setParentCategorie(categoryParent.get());
		}
		return repository.save(sCategorie);
	}
	

	@DeleteMapping("/scategories/{id}")
	public Map<String, Boolean> deleteScategorie(@PathVariable(value = "id") Long ScategorieId)
			throws ResourceNotFoundException {
		Scategorie Scategorie = repository.findById(ScategorieId)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie not found  id :: " + ScategorieId));

		repository.delete(Scategorie);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/scategories/delete")
	  public ResponseEntity<String> deleteAllScategories() {
	    System.out.println("Delete All Scategories...");
	    repository.deleteAll();
	    return new ResponseEntity<>("All Scategories have been deleted!", HttpStatus.OK);
	  }
	 
	

	  @PutMapping("/scategories/{id}")
	  public ResponseEntity<Scategorie> updateScategorie(@PathVariable("id") long id, @RequestBody Scategorie Scategorie) {
	    System.out.println("Update Scategorie with ID = " + id + "...");
	 
	    Optional<Scategorie> ScategorieInfo = repository.findById(id);
	 
	    if (ScategorieInfo.isPresent()) {
	    	Scategorie scategorie = ScategorieInfo.get();
	           scategorie.setLibScat(Scategorie.getLibScat());
	           scategorie.setParentCategorie(Scategorie.getParentCategorie());
	       	      return new ResponseEntity<>(repository.save(Scategorie), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PatchMapping("/scategories/5/{idCat}")
	  public ResponseEntity<Scategorie> updateScategorie(@PathVariable("idCat") long idCat) {
	    System.out.println("Update SCategorie with Code  = " + idCat + "...");
	 
	    Optional<Scategorie> ScategorieInfo = repository.findById(idCat);
	 
	    if (ScategorieInfo.isPresent()) {
	    	Scategorie scategorie = ScategorieInfo.get();
	   
	         
	      return new ResponseEntity<>(repository.save(scategorie), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}