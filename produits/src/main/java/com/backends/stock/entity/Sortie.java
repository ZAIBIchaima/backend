package com.backends.stock.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity 
@DiscriminatorValue("1")
public class Sortie extends Operation implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idDep;
	private String libDep;
	public Long getIdDep() {
		return idDep;
	}
	public void setIdDep(Long idDep) {
		this.idDep = idDep;
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
