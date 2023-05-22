package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Employe;
import com.inti.repositories.EmployeRepository;
import com.inti.services.interfaces.IEmployeService;

@Service
public class EmployeService implements IEmployeService {
	@Autowired
	EmployeRepository employeRepository;

	@Override
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}

	@Override
	public Employe findOne(Long id) {
		return employeRepository.findById(id).get();
	}

	@Override
	public Employe save(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public void delete(Long id) {
		employeRepository.deleteById(id);
	}


}
