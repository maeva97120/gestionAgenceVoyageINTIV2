package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IFermeDAO;
import com.inti.entities.Ferme;
import com.inti.utils.HibernateUtility;

public class FermeDAO implements IFermeDAO{

	@Override
	public void create(Ferme obj) {
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
	public void update(Ferme obj) {
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
			String hql = "delete Ferme where idFerme = :idFerme";
			Query queryHQL = session.createQuery(hql).setParameter("idFerme", 
					id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		
	}

	@Override
	public Ferme getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Ferme where idFerme = :idFerme");
			queryHQL.setParameter("idFerme", id);
			Ferme ferme = (Ferme) queryHQL.uniqueResult();
			session.close();
			return ferme;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Ferme> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Ferme");
			List<Ferme> fermes = queryHQL.list();
			session.close();
			return fermes;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
