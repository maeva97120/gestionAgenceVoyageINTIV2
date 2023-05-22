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
@Table(name = "CONTRATS", schema = "gestion_employe_db")
public class Contrat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContrat;
	private String typeContrat;
	private Long salaire;
	@ManyToOne
	@JoinColumn(name = "id_employe")
	private Employe employe;

	public Contrat() {

	}

	public Contrat(String typeContrat, Long salaire) {
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	public Long getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Long getSalaire() {
		return salaire;
	}

	public void setSalaire(Long salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + ", typeContrat=" + typeContrat + ", salaire=" + salaire
				+ ", employe=" + employe + "]";
	}

}
