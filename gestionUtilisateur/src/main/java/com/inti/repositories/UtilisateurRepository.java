package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	// JpaRepsitory : CRUD : findAll, findById, create, update ...
	
	Utilisateur findByNomUtilisateur(String nomUtilisateur);

	@Query(value = "select * from utilisateurs u where u.statut = true ", nativeQuery = true)
	List<Utilisateur> findUtilisateurByStatut(boolean statut);

	@Query(value = "select * from utilisateurs u where u.statut = ?1 and u.nom_utilisateur = ?2", nativeQuery = true)
	List<Utilisateur> findUtilisateurByStatutAndNom(boolean statut, String nom);
	
	// JPQL : (u : alias), (Utilisateur : class), (prenomUtilisateur : attribut de la classe Utilisateur)
	@Query("select u from Utilisateur u where u.prenomUtilisateur = ?1")
	List<Utilisateur> findUtilisateurByPrenom(String prenom);

}
