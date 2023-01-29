package com.backends.stock.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table
public class Linventaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;
	private double qteStock ;
	private double qteInvent ;
	  private int numInventaire;
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "inventId")
	@JsonBackReference
	private Inventaire invent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getQteStock() {
		return qteStock;
	}
	public void setQteStock(double qteStock) {
		this.qteStock = qteStock;
	}
	public double getQteInvent() {
		return qteInvent;
	}
	public void setQteInvent(double qteInvent) {
		this.qteInvent = qteInvent;
	}
	public int getNumInventaire() {
		return numInventaire;
	}
	public void setNumInventaire(int numInventaire) {
		this.numInventaire = numInventaire;
	}
	public Inventaire getInvent() {
		return invent;
	}
	public void setInvent(Inventaire invent) {
		this.invent = invent;
	}
	
	

}