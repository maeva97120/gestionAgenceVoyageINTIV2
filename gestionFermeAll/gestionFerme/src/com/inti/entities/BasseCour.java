package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("basse_cour")
public class BasseCour extends Animal implements Serializable {
	private String habitat;

	public BasseCour() {
		super();
	}

	public BasseCour(boolean etat, Ferme ferme, String habitat) {
		super(etat, ferme);
		this.habitat = habitat;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return "BasseCour [habitat=" + habitat + "]";
	}
	
}
