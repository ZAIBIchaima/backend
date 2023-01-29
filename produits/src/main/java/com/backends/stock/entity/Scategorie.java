package com.backends.stock.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Table(name = "scategorie")
@Data
@Entity 
public class Scategorie {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long idScat;
	  private String libScat;
	  @ManyToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="id_cat")
	  private Categorie parentCategorie;
	  @Transient
	  private long idCat;
	public long getIdScat() {
		return idScat;
	}
	public void setIdScat(long idScat) {
		this.idScat = idScat;
	}
	public String getLibScat() {
		return libScat;
	}
	public void setLibScat(String libScat) {
		this.libScat = libScat;
	}
	public Categorie getParentCategorie() {
		return parentCategorie;
	}
	public void setParentCategorie(Categorie parentCategorie) {
		this.parentCategorie = parentCategorie;
	}
	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	  
	  
	  
	  
}