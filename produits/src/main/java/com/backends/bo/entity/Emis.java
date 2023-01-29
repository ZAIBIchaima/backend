package com.backends.bo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor @ToString @AllArgsConstructor
public class Emis extends Courier{
	private String sentTo;
	
	@ManyToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="id_emis")
	  private Destinataire parentEmis;

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}
	
	

}
