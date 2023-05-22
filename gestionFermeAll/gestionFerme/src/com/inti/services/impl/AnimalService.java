package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.AnimalDAO;
import com.inti.dao.interfaces.IAnimalDAO;
import com.inti.entities.Animal;
import com.inti.services.interfaces.IAnimalService;

public class AnimalService implements IAnimalService{
	IAnimalDAO animalDAO = new AnimalDAO();

	@Override
	public void create(Animal obj) {
		animalDAO.create(obj);
	}

	@Override
	public void update(Animal obj) {
		animalDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		animalDAO.delete(id);
	}

	@Override
	public Animal getById(Long id) {
		return animalDAO.getById(id);
	}

	@Override
	public List<Animal> getAll() {
		return animalDAO.getAll();
	}
}
