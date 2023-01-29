package com.backends.stock.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.backends.exception.ResourceNotFoundException;
import com.backends.stock.entity.Fournisseur;
import com.backends.stock.repository.FournisseurRepository;

@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK')")
public class FournisseurController  {
		 @Autowired FournisseurRepository  repository;
			@GetMapping("/fournisseurs")
			  public List<Fournisseur> getAllFournisseurs() {
			     System.out.println("Get all fournisseurs...");
			    List<Fournisseur> fournisseurs = new ArrayList<>();
			    repository.findAll().forEach(fournisseurs::add);
			    return fournisseurs;
			  }
			@GetMapping("/fournisseurs/{id}")
			public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") Long Id)
					throws ResourceNotFoundException {
				Fournisseur fournisseur = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("fournisseur not found for this id :: " + Id));
				return ResponseEntity.ok().body(fournisseur);
			}
			@PostMapping("/fournisseurs")
			 public Fournisseur createFournisseur( @RequestBody Fournisseur fournisseur) {
				 return repository.save(fournisseur);
			 }
			@DeleteMapping("/fournisseurs/{id}")
			public Map<String,Boolean>deleteFournisseur(@PathVariable(value="id")Long FournisseurId)
					throws ResourceNotFoundException {
				Fournisseur Fournisseur = repository.findById(FournisseurId).orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id :: " + FournisseurId));
				repository.delete(Fournisseur);
				Map<String,Boolean>response=new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
			
		}
			@PutMapping("/fournisseurs/{id}")
			  public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id, @RequestBody Fournisseur Fournisseur) {
			    System.out.println("Update Fournisseur with ID = " + id + "...");
			    Optional<Fournisseur> FournisseurInfo = repository.findById(id);
			    if (FournisseurInfo.isPresent()) {
			    	Fournisseur fournisseur = FournisseurInfo.get();
			    	fournisseur.setNom(Fournisseur.getNom())   ; 
			    	fournisseur.setAdresse(Fournisseur.getAdresse())   ; 
			    	fournisseur.setContact(Fournisseur.getContact())   ; 
			      
			          
			      return new ResponseEntity<>(repository.save(fournisseur), HttpStatus.OK);
			    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
			  }

			@DeleteMapping("/Fournisseurs/delete")
			public ResponseEntity<String>deleteAllFournisseurs(){
				System.out.println("Delete All Fournisseurs");
				repository.deleteAll();
				return new ResponseEntity<>("All Fournisseurs have been deleted!",HttpStatus.OK);
			}

}