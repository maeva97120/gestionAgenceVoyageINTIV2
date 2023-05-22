package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.UtilisateurDAO;
import com.inti.dao.interfaces.IUtilisateurDAO;
import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IUtilisateurService;

public class UtilisateurService implements IUtilisateurService {
	IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	@Override
	public void create(Utilisateur obj) {
		utilisateurDAO.create(obj);
	}

	@Override
	public void update(Utilisateur obj) {
		utilisateurDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		utilisateurDAO.delete(id);
	}

	@Override
	public Utilisateur getById(Long id) {
		return utilisateurDAO.getById(id);
	}

	@Override
	public List<Utilisateur> getAll() {
		return utilisateurDAO.getAll();
	}

}
