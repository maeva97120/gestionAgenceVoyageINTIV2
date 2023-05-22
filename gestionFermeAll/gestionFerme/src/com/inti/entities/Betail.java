package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("betail")
public class Betail extends Animal implements Serializable {
	private String techElevage;

	public Betail() {
		super();
	}

	public Betail(boolean etat, Ferme ferme, String techElevage) {
		super(etat, ferme);
		this.techElevage = techElevage;
	}

	public String getTechElevage() {
		return techElevage;
	}

	public void setTechElevage(String techElevage) {
		this.techElevage = techElevage;
	}

	@Override
	public String toString() {
		return "Betail [techElevage=" + techElevage + ", toString()=" + super.toString() + "]";
	}

}
