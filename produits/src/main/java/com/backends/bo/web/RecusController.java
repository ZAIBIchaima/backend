package com.backends.bo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.backends.bo.entity.Recus;

import com.backends.bo.repository.RecusRepository;

@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('BO')")
public class RecusController {
	@Autowired
	private RecusRepository recusRepository;
	
	@GetMapping(value="/listrecus")	
	public List<Recus> listRecus(){
		return recusRepository.findAll();
	}
	
	@GetMapping("/listrecus/{id}")
	public Recus listRecus(@PathVariable(name="id") Long id){
		return recusRepository.findById(id).get();
	}
	
	
	@PostMapping(value="/listrecus")
	public Recus createRecus( @RequestBody Recus Recus){
		return recusRepository.save(Recus);
	}
	
	@PutMapping(value="/listrecus/{id}")
	public Recus updateRecus(@PathVariable(name="id") Long id, @RequestBody Recus Recus){
		Recus.setId(id);
		return recusRepository.save(Recus);
	}
	
	@DeleteMapping(value="/listrecus/{id}")
	public void deleteRecus(@PathVariable(name="id") Long id){
		recusRepository.deleteById(id);
	}

}
