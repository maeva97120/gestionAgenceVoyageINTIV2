package com.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UTILISATEURS", schema = "gestion_ferme_db")
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private int age;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@OneToOne
	@JoinColumn(name = "id_ferme")
	private Ferme ferme;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILS", 
	joinColumns = @JoinColumn(name = "id_utilisateur", 
	referencedColumnName = "idUtilisateur"), 
	inverseJoinColumns = 
	@JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();
	
	public Utilisateur() {
	}
	
	public Utilisateur(String nom, String prenom, String username, String password, int age, Date dateNaissance,
			Ferme ferme, Set<Role> roles) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.ferme = ferme;
		this.roles = roles;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Ferme getFerme() {
		return ferme;
	}
	public void setFerme(Ferme ferme) {
		this.ferme = ferme;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", username="
				+ username + ", password=" + password + ", age=" + age + ", dateNaissance=" + dateNaissance + ", ferme="
				+ ferme + ", roles=" + roles + "]";
	}
	
}
