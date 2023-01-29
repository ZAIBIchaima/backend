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
public class Recus extends Courier{
	private boolean isForwaded = false;
	@ManyToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="id_canal")
	  private Canal parentRecus;

	public boolean isForwaded() {
		return isForwaded;
	}

	public void setForwaded(boolean isForwaded) {
		this.isForwaded = isForwaded;
	}
	

}
