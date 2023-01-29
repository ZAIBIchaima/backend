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

import com.backends.bo.entity.Emis;
import com.backends.bo.repository.EmitRepository;


@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('BO')")
public class EmitController {
	@Autowired
	private EmitRepository emitRepository;
	
	@GetMapping(value="/listemit")	
	public List<Emis> listEmits(){
		return emitRepository.findAll();
	}
	
	@GetMapping("/listemit/{id}")
	public Emis listCouriers(@PathVariable(name="id") Long id){
		return emitRepository.findById(id).get();
	}
	
	
	@PostMapping(value="/listemit")
	public Emis createEmit( @RequestBody Emis Emis){
		return emitRepository.save(Emis);
	}
	
	@PutMapping(value="/listemit/{id}")
	public Emis updateEmit(@PathVariable(name="id") Long id, @RequestBody Emis Emis){
		Emis.setId(id);
		return emitRepository.save(Emis);
	}
	
	@DeleteMapping(value="/listemit/{id}")
	public void deleteEmit(@PathVariable(name="id") Long id){
		emitRepository.deleteById(id);
	}

}
