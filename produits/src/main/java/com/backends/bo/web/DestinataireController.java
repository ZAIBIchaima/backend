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

import com.backends.bo.entity.Destinataire;
import com.backends.bo.repository.DestinataireRepository;


@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('BO')")
public class DestinataireController {
	@Autowired
	private DestinataireRepository destinataireRepository;
	
	@GetMapping(value="/listdestinataire")	
	public List<Destinataire> listDestinataires(){
		return destinataireRepository.findAll();
	}
	
	@GetMapping("/listdestinataire/{id}")
	public Destinataire listDestinataires(@PathVariable(name="id") Long id){
		return destinataireRepository.findById(id).get();
	}
	
	
	@PostMapping(value="/listdestinataire")
	public Destinataire createDestinataire( @RequestBody Destinataire Destinataire){
		return destinataireRepository.save(Destinataire);
	}
	
	@PutMapping(value="/listdestinataire/{id}")
	public Destinataire updateDestinataire(@PathVariable(name="id") Long id, @RequestBody Destinataire Destinataire){
		Destinataire.setId(id);
		return destinataireRepository.save(Destinataire);
	}
	
	@DeleteMapping(value="/listdestinataire/{id}")
	public void deleteDestinataire(@PathVariable(name="id") Long id){
		destinataireRepository.deleteById(id);
	}


}
