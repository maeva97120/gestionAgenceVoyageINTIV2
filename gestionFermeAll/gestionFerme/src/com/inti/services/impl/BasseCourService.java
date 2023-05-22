package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.BasseCourDAO;
import com.inti.dao.interfaces.IBasseCourDAO;
import com.inti.entities.BasseCour;
import com.inti.services.interfaces.IBasseCourService;

public class BasseCourService implements IBasseCourService{
	IBasseCourDAO basseCourDAO = new BasseCourDAO();

	@Override
	public void create(BasseCour obj) {
		basseCourDAO.create(obj);
	}

	@Override
	public void update(BasseCour obj) {
		basseCourDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		basseCourDAO.delete(id);
	}

	@Override
	public BasseCour getById(Long id) {
		return basseCourDAO.getById(id);
	}

	@Override
	public List<BasseCour> getAll() {
		return basseCourDAO.getAll();
	}
}
