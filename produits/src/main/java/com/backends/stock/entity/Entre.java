package com.backends.stock.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity 
@DiscriminatorValue("2")
public class Entre extends Operation implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idF;
	private String nomF;
	public Long getIdF() {
		return idF;
	}
	public void setIdF(Long idF) {
		this.idF = idF;
	}
	public String getNomF() {
		return nomF;
	}
	public void setNomF(String nomF) {
		this.nomF = nomF;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}