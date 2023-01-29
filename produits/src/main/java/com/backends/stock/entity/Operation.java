package com.backends.stock.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.DiscriminatorType;
@Entity
@Data 
@NoArgsConstructor @ToString @AllArgsConstructor
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="typeOperation", discriminatorType = DiscriminatorType.INTEGER )
public class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateOperation;
	private String refOperation;
	private String numeroOperation;
	  @JsonManagedReference
	  @OneToMany(mappedBy ="operation", fetch=FetchType.EAGER)

	private List<DetailsOperation> detailsoperations = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public String getRefOperation() {
		return refOperation;
	}
	public void setRefOperation(String refOperation) {
		this.refOperation = refOperation;
	}
	public String getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(String numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public List<DetailsOperation> getDetailsoperations() {
		return detailsoperations;
	}
	public void setDetailsoperations(List<DetailsOperation> detailsoperations) {
		this.detailsoperations = detailsoperations;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	};
	
	
	
	
	
}
