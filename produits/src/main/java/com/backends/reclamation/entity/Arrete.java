package com.backends.reclamation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import java.time.LocalDate;
import com.backends.reclamation.entity.Infraction;

@Entity
public class Arrete {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idArrete;
	private int numArrete;
	private LocalDate dateArrete;
	private String descriptionArrete;
	private String objetArrete;
	private LocalDate dateExecution;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_Infraction")
	private Infraction parentInfraction;
	@Transient
	private long idInfraction;
	public Long getIdArrete() {
		return idArrete;
	}
	public void setIdArrete(Long idArrete) {
		this.idArrete = idArrete;
	}
	public int getNumArrete() {
		return numArrete;
	}
	public void setNumArrete(int numArrete) {
		this.numArrete = numArrete;
	}
	public LocalDate getDateArrete() {
		return dateArrete;
	}
	public void setDateArrete(LocalDate dateArrete) {
		this.dateArrete = dateArrete;
	}
	public String getDescriptionArrete() {
		return descriptionArrete;
	}
	public void setDescriptionArrete(String descriptionArrete) {
		this.descriptionArrete = descriptionArrete;
	}
	public String getObjetArrete() {
		return objetArrete;
	}
	public void setObjetArrete(String objetArrete) {
		this.objetArrete = objetArrete;
	}
	public LocalDate getDateExecution() {
		return dateExecution;
	}
	public void setDateExecution(LocalDate dateExecution) {
		this.dateExecution = dateExecution;
	}
	public Infraction getParentInfraction() {
		return parentInfraction;
	}
	public void setParentInfraction(Infraction parentInfraction) {
		this.parentInfraction = parentInfraction;
	}
	public long getIdInfraction() {
		return idInfraction;
	}
	public void setIdInfraction(long idInfraction) {
		this.idInfraction = idInfraction;
	}
	
	

}
