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

import com.backends.stock.entity.Inventaire;
import com.backends.stock.entity.Linventaire;
import com.backends.stock.repository.InventaireRepository;
import com.backends.stock.repository.LinventaireRepository;
import com.backends.exception.ResourceNotFoundException;
@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK') ")
public class LinventaireController {
	@Autowired
	LinventaireRepository repository;
	@Autowired InventaireRepository rep;
	@GetMapping("/linvents")
	  public List<Linventaire> getAllLinvents() {
	    System.out.println("Get all Linvents...");
	 
	    List<Linventaire> Linvents = new ArrayList<>();
	    repository.findAll().forEach(Linvents::add);
	 
	    return Linvents;
	  }
	
	@GetMapping("/linvents/{id}")
	public ResponseEntity<Linventaire> getLinventById(@PathVariable(value = "id") Long LinventId)
			throws ResourceNotFoundException {
		Linventaire Linvent = repository.findById(LinventId)
				.orElseThrow(() -> new ResourceNotFoundException("Linvent not found for this id :: " + LinventId));
		return ResponseEntity.ok().body(Linvent);
	}

	@PostMapping("/linvents")
	public  Linventaire createLinvent( @RequestBody Linventaire linvent) {
		
		
		    return repository.save(linvent);
		
		 
	}
	

	@DeleteMapping("/linvents/{id}")
	public Map<String, Boolean> deleteLinvent(@PathVariable(value = "id") Long LinventId)
			throws ResourceNotFoundException {
		Linventaire Linvent = repository.findById(LinventId)
				.orElseThrow(() -> new ResourceNotFoundException("Linvent not found  id :: " + LinventId));

		repository.delete(Linvent);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	 
	  @DeleteMapping("/linvents/delete")
	  public ResponseEntity<String> deleteAllLinvents() {
	    System.out.println("Delete All Linvents...");
	    repository.deleteAll();
	    return new ResponseEntity<>("All Linvents have been deleted!", HttpStatus.OK);
	  }
	 
	  @PutMapping("/linvents/{id}")
	  public ResponseEntity<Linventaire> updateLinvent(@PathVariable("id") long id, @RequestBody Linventaire Linvent) {
	    System.out.println("Update Invent with ID = " + id + "...");
	    Optional<Linventaire> LinventInfo = repository.findById(id);
	    if (LinventInfo.isPresent()) {
	    	Linventaire linvent = LinventInfo.get();
	    	linvent.setId(Linvent.getId());
	    	linvent.setQteInvent(Linvent.getQteInvent());
	     	linvent.setQteStock(Linvent.getQteStock());
	      return new ResponseEntity<>(repository.save(Linvent), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	  
	  }