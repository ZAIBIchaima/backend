package com.backends.commun.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.backends.stock.entity.Sortie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor @ToString @AllArgsConstructor

public class Departement implements Serializable {

	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
		
		private Long id;
		
		private String libDep;
		

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibDep() {
		return libDep;
	}

	public void setLibDep(String libDep) {
		this.libDep = libDep;
	}

	

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
