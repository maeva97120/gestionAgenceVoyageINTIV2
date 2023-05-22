package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.BetailDAO;
import com.inti.dao.interfaces.IBetailDAO;
import com.inti.entities.Betail;
import com.inti.services.interfaces.IBetailService;

public class BetailService implements IBetailService{
	IBetailDAO betailDAO = new BetailDAO();

	@Override
	public void create(Betail obj) {
		betailDAO.create(obj);
	}

	@Override
	public void update(Betail obj) {
		betailDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		betailDAO.delete(id);
	}

	@Override
	public Betail getById(Long id) {
		return betailDAO.getById(id);
	}

	@Override
	public List<Betail> getAll() {
		return betailDAO.getAll();
	}
}
