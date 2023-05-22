package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.SocieteDAO;
import com.inti.dao.interfaces.ISocieteDAO;
import com.inti.entities.Societe;
import com.inti.services.interfaces.ISocieteService;

public class SocieteService implements ISocieteService {
	ISocieteDAO societeDAO = new SocieteDAO();

	@Override
	public void create(Societe obj) {
		societeDAO.create(obj);

	}

	@Override
	public void update(Societe obj) {
		societeDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		societeDAO.delete(id);
	}

	@Override
	public Societe getById(Long id) {
		return societeDAO.getById(id);
	}

	@Override
	public List<Societe> getAll() {
		return societeDAO.getAll();
	}

}
