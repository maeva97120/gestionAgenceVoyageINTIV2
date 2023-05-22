package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIETES", schema = "hibernate_one_to_many_db")
public class Societe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSociete;
	private String nomSociete;
	@OneToMany(mappedBy = "societe")
	private List<Departement> departements = new ArrayList<>();

	public Societe() {
	}

	public Societe(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public Long getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Long idSociete) {
		this.idSociete = idSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}

	@Override
	public String toString() {
		return "Societe [idSociete=" + idSociete + ", nomSociete=" + nomSociete + "]";
	}

}
