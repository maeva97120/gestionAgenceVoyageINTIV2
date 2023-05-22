package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Voiture;
import com.inti.repositories.VoitureRepository;
import com.inti.services.interfaces.IVoitureService;

@Service
public class VoitureService implements IVoitureService {
	@Autowired
	VoitureRepository voitureRepository;

	@Override
	public List<Voiture> findAll() {
		return voitureRepository.findAll();
	}

	@Override
	public Voiture findOne(Long id) {
		return voitureRepository.findById(id).get();
	}

	@Override
	public Voiture save(Voiture voiture) {
		return voitureRepository.save(voiture);
	}

	@Override
	public void delete(Long id) {
		voitureRepository.deleteById(id);
	}

}
