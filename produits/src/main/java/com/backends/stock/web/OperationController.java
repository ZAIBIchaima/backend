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

import com.backends.exception.ResourceNotFoundException;
import com.backends.stock.entity.DetailsOperation;
import com.backends.stock.entity.Operation;
import com.backends.stock.repository.DetailsOperationRepository;
import com.backends.stock.repository.OperationRepository;
import com.fasterxml.jackson.databind.JsonMappingException;



@ CrossOrigin ( origins = "http://localhost:4200" )
@ RestController
@ RequestMapping ( "/api" )
@PreAuthorize("hasRole('ADMIN') or hasRole('STOCK') ")
public class OperationController {
	@Autowired 	OperationRepository  repository;
	@Autowired 	DetailsOperationRepository  rep;
	 @GetMapping("/operations")
	  public List<Operation> getAllOperations() {
	     System.out.println("Get all Operations...");
	 
	    List<Operation> operations = new ArrayList<>();
	    repository.findAll().forEach(operations::add);
	 
	    return operations;
	  }
	 
	 @GetMapping("/operations/{id}")
		public ResponseEntity<Operation> getOperationById(@PathVariable(value = "id") Long Id)
				throws ResourceNotFoundException {
		 Operation Operation = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Operation not found for this id :: " + Id));
			return ResponseEntity.ok().body(Operation);
		}
	 
	
	 @PostMapping("/operations")
			public ResponseEntity<Operation> createInvent( @RequestBody Operation operation)  throws JsonParseException , JsonMappingException , Exception{

		 repository.save(operation);
			List<DetailsOperation> detailsoperations = operation.getDetailsoperations();
		    for (DetailsOperation lc : detailsoperations) {
		        lc.setNumeroOperation(operation.getNumeroOperation());
	       		rep.save(lc);
		       }	 
		
			 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 

	 @DeleteMapping("/operations/{id}")
		public Map<String,Boolean>deleteOperation(@PathVariable(value="id")Long OperationId)
				throws ResourceNotFoundException {
		 Operation Operation = repository.findById(OperationId).orElseThrow(() -> new ResourceNotFoundException("Operation not found for this id :: " + OperationId));
			repository.delete(Operation);
			Map<String,Boolean>response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		
	}
	 @DeleteMapping("/Operations/delete")
		public ResponseEntity<String>deleteAllOperations(){
			System.out.println("Delete All Operations");
			repository.deleteAll();
			return new ResponseEntity<>("All Operations have been deleted!",HttpStatus.OK);
		}

	  @PutMapping("/operations/{id}")
	  public ResponseEntity<Operation> updateOperation(@PathVariable("id") long id, @RequestBody Operation Operation) {
	    System.out.println("Update Operation with ID = " + id + "...");
	    Optional<Operation> OperationInfo = repository.findById(id);
	    if (OperationInfo.isPresent()) {
	    	Operation operation = OperationInfo.get();
	    	operation.setRefOperation(Operation.getRefOperation());
	    	operation.setDateOperation(Operation.getDateOperation())   ; 
	    	operation.setNumeroOperation(Operation.getNumeroOperation());  
	    	operation.setDetailsoperations(Operation.getDetailsoperations());  

	      return new ResponseEntity<>(repository.save(Operation), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
