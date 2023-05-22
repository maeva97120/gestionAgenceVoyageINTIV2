package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IBetailDAO;
import com.inti.entities.Betail;
import com.inti.utils.HibernateUtility;

public class BetailDAO implements IBetailDAO{
	@Override
	public void create(Betail obj) {
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
	public void update(Betail obj) {
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
			String hql = "delete Betail where idAnimal = :id";
			Query queryHQL = session.createQuery(hql).setParameter("id", 
					id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		
	}

	@Override
	public Betail getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Betail where idAnimal = :id");
			queryHQL.setParameter("id", id);
			Betail ferme = (Betail) queryHQL.uniqueResult();
			session.close();
			return ferme;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Betail> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Betail");
			List<Betail> fermes = queryHQL.list();
			session.close();
			return fermes;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
