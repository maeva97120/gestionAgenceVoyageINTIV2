package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VOITURES", schema = "gestion_employe_db")
public class Voiture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	private String marque;
	private String vitesse;
	private String couleur;
	@OneToOne
	@JoinColumn(name = "id_emp")
	private Employe employeForeignKey;

	public Voiture() {

	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getVitesse() {
		return vitesse;
	}

	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Employe getEmployeForeignKey() {
		return employeForeignKey;
	}

	public void setEmployeForeignKey(Employe employeForeignKey) {
		this.employeForeignKey = employeForeignKey;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", marque=" + marque + ", vitesse=" + vitesse + ", couleur="
				+ couleur + ", employeForeignKey=" + employeForeignKey + "]";
	}

}
