package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.DepartementDAO;
import com.inti.dao.interfaces.IDepartementDAO;
import com.inti.entities.Departement;
import com.inti.services.interfaces.IDepartementService;

public class DepartementService implements IDepartementService {
	IDepartementDAO departementDAO = new DepartementDAO();

	@Override
	public void create(Departement obj) {
		departementDAO.create(obj);
	}

	@Override
	public void update(Departement obj) {
		departementDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		departementDAO.delete(id);
	}

	@Override
	public Departement getById(Long id) {
		return departementDAO.getById(id);
	}

	@Override
	public List<Departement> getAll() {
		return departementDAO.getAll();
	}

}
