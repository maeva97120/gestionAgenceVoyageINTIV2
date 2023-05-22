package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "DEPARTEMENTS", schema = "hibernate_one_to_many_db")
public class Departement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	private String codeDepartement;
	private String nomDepartement;
	@ManyToOne // societe_idSociete <=> id_societe
	@JoinColumn(name="id_societe")
	private Societe societe;
	public Departement() {
	}
	public Departement(String codeDepartement, String nomDepartement, Societe societe) {
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.societe = societe;
	}
	public Long getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement
				+ ", nomDepartement=" + nomDepartement + ", societe=" + societe + "]";
	}
	
}
