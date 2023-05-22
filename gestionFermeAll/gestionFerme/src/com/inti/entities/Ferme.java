package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.inti.model.Adresse;

@Entity
@Table(name = "FERMES", schema = "gestion_ferme_db")
public class Ferme implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFerme;
	private String nomFerme;
	@Embedded
	private Adresse adresse;
	@OneToOne(mappedBy = "ferme")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "ferme")
	private List<Animal> animaux = new ArrayList<>();

	public Ferme() {
	}

	public Ferme(String nomFerme) {
		this.nomFerme = nomFerme;
	}

	public Ferme(String nomFerme, Adresse adresse) {
		this.nomFerme = nomFerme;
		this.adresse = adresse;
	}

	public Long getIdFerme() {
		return idFerme;
	}

	public void setIdFerme(Long idFerme) {
		this.idFerme = idFerme;
	}

	public String getNomFerme() {
		return nomFerme;
	}

	public void setNomFerme(String nomFerme) {
		this.nomFerme = nomFerme;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Ferme [idFerme=" + idFerme + ", nomFerme=" + nomFerme + ", adresse=" + adresse + "]";
	}

}
