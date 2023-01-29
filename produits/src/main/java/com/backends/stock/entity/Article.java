package com.backends.stock.entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor @ToString @AllArgsConstructor
public class Article implements Serializable {

	 
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String reference;
	private String libelle;
	private double qteStock;
	private double qteMin;
	private double qteCri;
	private Date dateCreation;
	private long idScat;
	private long idCat;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
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
	public double getQteMin() {
		return qteMin;
	}
	public void setQteMin(double qteMin) {
		this.qteMin = qteMin;
	}
	public double getQteCri() {
		return qteCri;
	}
	public void setQteCri(double qteCri) {
		this.qteCri = qteCri;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public long getIdScat() {
		return idScat;
	}
	public void setIdScat(long idScat) {
		this.idScat = idScat;
	}
	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}