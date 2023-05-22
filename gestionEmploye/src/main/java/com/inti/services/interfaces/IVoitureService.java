package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Voiture;

public interface IVoitureService {

	List<Voiture> findAll();

	Voiture findOne(Long id);

	Voiture save(Voiture voiture);

	void delete(Long id);
}
