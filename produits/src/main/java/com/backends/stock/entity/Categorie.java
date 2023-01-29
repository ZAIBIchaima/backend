
package com.backends.stock.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString 
public class Categorie implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long idCat;
	private String libCat;
	@JsonIgnore
	@OneToMany(mappedBy ="parentCategorie", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Scategorie> sCategories;
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getLibCat() {
		return libCat;
	}
	public void setLibCat(String libCat) {
		this.libCat = libCat;
	}
	public Set<Scategorie> getsCategories() {
		return sCategories;
	}
	public void setsCategories(Set<Scategorie> sCategories) {
		this.sCategories = sCategories;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}