package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Entreprise;

public interface IEntrepriseService {
	List<Entreprise> findAll();

	Entreprise findOne(Long id);

	Entreprise save(Entreprise entreprise);

	void delete(Long id);

}
