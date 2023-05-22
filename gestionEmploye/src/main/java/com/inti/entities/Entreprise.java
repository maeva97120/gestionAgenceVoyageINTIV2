package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ENTREPRISES", schema = "gestion_employe_db")
public class Entreprise implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntreprise;
	@Column(name = "nom_entreprise")
	private String nomEntreprise;
	private String adresse;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILS", joinColumns = @JoinColumn(name = "id_ent", referencedColumnName = "idEntreprise"), inverseJoinColumns = @JoinColumn(name = "id_employe", referencedColumnName = "idEmploye"))
	private Set<Employe> employes = new HashSet<>();

	public Entreprise() {

	}

	public Entreprise(String nomEntreprise, String adresse, Set<Employe> employes) {
		this.nomEntreprise = nomEntreprise;
		this.adresse = adresse;
		this.employes = employes;
	}

	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Entreprise [idEntreprise=" + idEntreprise + ", nomEntreprise=" + nomEntreprise + ", adresse=" + adresse
				+ ", employes=" + employes + "]";
	}

}
