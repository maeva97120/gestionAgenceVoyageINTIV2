package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IDepartementDAO;
import com.inti.entities.Departement;
import com.inti.utils.HibernateUtility;

public class DepartementDAO implements IDepartementDAO{

	@Override
	public void create(Departement obj) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Departement obj) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			String hql = "delete Departement where idDepartement = :idDepartement";
			Query queryHQL = session.createQuery(hql).setParameter("idDepartement", 
					id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		
	}

	@Override
	public Departement getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Departement where idDepartement = :idDept");
			queryHQL.setParameter("idDept", id);
			Departement dept = (Departement) queryHQL.uniqueResult();
			return dept;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Departement> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Departement");
			List<Departement> departements = queryHQL.list();
			return departements;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
