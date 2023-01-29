package com.backends.stock.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
@Entity
@Data
@Table
public class Inventaire {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int numInventaire;
	  private Date dateInventaire;
	  @JsonManagedReference
	    @OneToMany(mappedBy = "invent")
	    private List<Linventaire> linvents = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumInventaire() {
		return numInventaire;
	}
	public void setNumInventaire(int numInventaire) {
		this.numInventaire = numInventaire;
	}
	public Date getDateInventaire() {
		return dateInventaire;
	}
	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}
	public List<Linventaire> getLinvents() {
		return linvents;
	}
	public void setLinvents(List<Linventaire> linvents) {
		this.linvents = linvents;
	}
	  
	  
	  
}