package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IRoleDAO;
import com.inti.entities.Role;
import com.inti.utils.HibernateUtility;

public class RoleDAO implements IRoleDAO{
	@Override
	public void create(Role obj) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void update(Role obj) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(obj);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(Long id) { 
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			String hql = "delete Role where idRole = :idRole";
			Query queryHQL = session.createQuery(hql).setParameter("idRole", id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Role getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Role where idRole = :idRole");
			queryHQL.setParameter("idRole", id);
			Role role = (Role) queryHQL.uniqueResult();
			return role;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Role> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Role");
			List<Role> roles = queryHQL.list();
			session.close();
			return roles;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
