package com.backends.reclamation.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.geo.Point;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="infractionss")
public class Infraction {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idInfraction;
	private int numInfraction;
	private LocalDate dateInfraction;
	//private LocalDate heureInfraction;
	private int cinSourceInfraction;
	private String descriptionInfraction;
	private String niveauTraveaux;
	private String degats;
	private String descriptions;
	private int code_reclamation;
	private int numReclamation; 
	private int idF;
	
	
	@Override
	public String toString() {
		return "Infraction [idInfraction=" + idInfraction + ", numInfraction=" + numInfraction + ", dateInfraction="
				+ dateInfraction + ", cinSourceInfraction=" + cinSourceInfraction + ", descriptionInfraction="
				+ descriptionInfraction + ", niveauTraveaux=" + niveauTraveaux + ", degats=" + degats
				+ ", descriptions=" + descriptions + ", code_reclamation=" + code_reclamation + ", numReclamation="
				+ numReclamation + ", idF=" + idF + ", nom=" + nom + "]";
	}
	public Infraction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Infraction(Long idInfraction, int numInfraction, LocalDate dateInfraction, int cinSourceInfraction,
			String descriptionInfraction, String niveauTraveaux, String degats, String descriptions,
			int code_reclamation, int numReclamation, int idF, String nom) {
		super();
		this.idInfraction = idInfraction;
		this.numInfraction = numInfraction;
		this.dateInfraction = dateInfraction;
		this.cinSourceInfraction = cinSourceInfraction;
		this.descriptionInfraction = descriptionInfraction;
		this.niveauTraveaux = niveauTraveaux;
		this.degats = degats;
		this.descriptions = descriptions;
		this.code_reclamation = code_reclamation;
		this.numReclamation = numReclamation;
		this.idF = idF;
		this.nom = nom;
	}
	public int getCode_reclamation() {
		return code_reclamation;
	}
	public void setCode_reclamation(int code_reclamation) {
		this.code_reclamation = code_reclamation;
	}
	public int getNumReclamation() {
		return numReclamation;
	}
	public void setNumReclamation(int numReclamation) {
		this.numReclamation = numReclamation;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	private String nom;
	
	/*@OneToOne
	@JoinColumn(name = "idReclamation")
	private Reclamation reclamation;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Employe employe;*/
	
	public Long getIdInfraction() {
		return idInfraction;
	}
	public void setIdInfraction(Long idInfraction) {
		this.idInfraction = idInfraction;
	}
	public int getNumInfraction() {
		return numInfraction;
	}
	public void setNumInfraction(int numInfraction) {
		this.numInfraction = numInfraction;
	}
	public LocalDate getDateInfraction() {
		return dateInfraction;
	}
	public void setDateInfraction(LocalDate dateInfraction) {
		this.dateInfraction = dateInfraction;
	}
	
	public int getCinSourceInfraction() {
		return cinSourceInfraction;
	}
	public void setCinSourceInfraction(int cinSourceInfraction) {
		this.cinSourceInfraction = cinSourceInfraction;
	}
	public String getDescriptionInfraction() {
		return descriptionInfraction;
	}
	public void setDescriptionInfraction(String descriptionInfraction) {
		this.descriptionInfraction = descriptionInfraction;
	}
	public String getNiveauTraveaux() {
		return niveauTraveaux;
	}
	public void setNiveauTraveaux(String niveauTraveaux) {
		this.niveauTraveaux = niveauTraveaux;
	}
	public String getDegats() {
		return degats;
	}
	public void setDegats(String degats) {
		this.degats = degats;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	
	/*@OneToOne(mappedBy = "reclamation")
	 private Reclamation reclamation;*/
	
	
	
}
