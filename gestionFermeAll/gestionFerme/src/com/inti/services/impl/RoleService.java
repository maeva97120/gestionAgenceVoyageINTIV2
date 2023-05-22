package com.inti.services.impl;

import java.util.List;

import com.inti.dao.impl.RoleDAO;
import com.inti.dao.interfaces.IRoleDAO;
import com.inti.entities.Role;
import com.inti.services.interfaces.IRoleService;

public class RoleService implements IRoleService{
	IRoleDAO roleDAO = new RoleDAO();

	@Override
	public void create(Role obj) {
		roleDAO.create(obj);

	}

	@Override
	public void update(Role obj) {
		roleDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		roleDAO.delete(id);
	}

	@Override
	public Role getById(Long id) {
		return roleDAO.getById(id);
	}

	@Override
	public List<Role> getAll() {
		return roleDAO.getAll();
	}
}
