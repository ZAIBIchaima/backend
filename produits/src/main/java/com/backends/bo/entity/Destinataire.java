package com.backends.bo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor @ToString @AllArgsConstructor
public class Destinataire {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	@JsonIgnore
	@OneToMany(mappedBy ="parentEmis", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Emis> emis;
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
