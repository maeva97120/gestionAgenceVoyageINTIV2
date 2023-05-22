package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Contrat;
import com.inti.repositories.ContratRepository;
import com.inti.services.interfaces.IContratService;

@Service
public class ContratService implements IContratService {
	@Autowired
	ContratRepository contratRepository;

	@Override
	public List<Contrat> findAll() {
		return contratRepository.findAll();
	}

	@Override
	public Contrat findOne(Long id) {
		return contratRepository.findById(id).get();
	}

	@Override
	public Contrat save(Contrat contrat) {
		return contratRepository.save(contrat);
	}

	@Override
	public void delete(Long id) {
		contratRepository.deleteById(id);
	}

}
