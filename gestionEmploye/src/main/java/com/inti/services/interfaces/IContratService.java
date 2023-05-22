package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Contrat;

public interface IContratService {

	List<Contrat> findAll();

	Contrat findOne(Long id);

	Contrat save(Contrat contrat);

	void delete(Long id);
}
