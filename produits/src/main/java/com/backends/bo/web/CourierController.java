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

import com.backends.bo.entity.Courier;
import com.backends.bo.repository.CourierRepository;



@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('BO')")
public class CourierController {
	@Autowired
	private CourierRepository courierRepository;
	
	@GetMapping(value="/listcourier")	
	public List<Courier> listReclamations(){
		return courierRepository.findAll();
	}
	
	@GetMapping("/listcourier/{id}")
	public Courier listCouriers(@PathVariable(name="id") Long id){
		return courierRepository.findById(id).get();
	}
	
	
	@PostMapping(value="/listcourier")
	public Courier createCourier( @RequestBody Courier Courier){
		return courierRepository.save(Courier);
	}
	
	@PutMapping(value="/listcourier/{id}")
	public Courier updateCourier(@PathVariable(name="id") Long id, @RequestBody Courier Courier){
		Courier.setId(id);
		return courierRepository.save(Courier);
	}
	
	@DeleteMapping(value="/listcourier/{id}")
	public void deleteCourier(@PathVariable(name="id") Long id){
		courierRepository.deleteById(id);
	}


}
