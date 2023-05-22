package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.FermeDAO;
import com.inti.dao.interfaces.IFermeDAO;
import com.inti.entities.Ferme;
import com.inti.services.interfaces.IFermeService;

public class FermeService implements IFermeService {
	IFermeDAO fermeDAO = new FermeDAO();

	@Override
	public void create(Ferme obj) {
		fermeDAO.create(obj);
	}

	@Override
	public void update(Ferme obj) {
		fermeDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		fermeDAO.delete(id);
	}

	@Override
	public Ferme getById(Long id) {
		return fermeDAO.getById(id);
	}

	@Override
	public List<Ferme> getAll() {
		return fermeDAO.getAll();
	}

}
