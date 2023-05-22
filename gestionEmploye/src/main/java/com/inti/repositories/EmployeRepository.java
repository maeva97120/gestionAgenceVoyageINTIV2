package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inti.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

	Employe findByNomEmploye(String nomEmploye);

	@Query("select u from Employe u where u.prenomEmploye = ?1")
	List<Employe> findEmployeByPrenom(String prenom);
	
}
