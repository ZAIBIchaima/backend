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

import com.backends.bo.entity.Canal;
import com.backends.bo.repository.CanalRepository;


@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('BO')")
public class CanalController {
	@Autowired
	private CanalRepository canalRepository;
	
	@GetMapping(value="/listcanal")	
	public List<Canal> listReclamations(){
		return canalRepository.findAll();
	}
	
	@GetMapping("/listcanal/{id}")
	public Canal listCanals(@PathVariable(name="id") Long id){
		return canalRepository.findById(id).get();
	}
	
	
	@PostMapping(value="/listcanal")
	public Canal createCanal( @RequestBody Canal Canal){
		return canalRepository.save(Canal);
	}
	
	@PutMapping(value="/listcanal/{id}")
	public Canal updateCanal(@PathVariable(name="id") Long id, @RequestBody Canal Canal){
		Canal.setId(id);
		return canalRepository.save(Canal);
	}
	
	@DeleteMapping(value="/listcanal/{id}")
	public void deleteCanal(@PathVariable(name="id") Long id){
		canalRepository.deleteById(id);
	}

}
