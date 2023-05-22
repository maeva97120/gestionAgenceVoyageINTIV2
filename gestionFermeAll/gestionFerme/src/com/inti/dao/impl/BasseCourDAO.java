package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IBasseCourDAO;
import com.inti.entities.BasseCour;
import com.inti.utils.HibernateUtility;

public class BasseCourDAO implements IBasseCourDAO{
	@Override
	public void create(BasseCour obj) {
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
	public void update(BasseCour obj) {
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
			String hql = "delete BasseCour where idAnimal = :id";
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
	public BasseCour getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from BasseCour where idAnimal = :id");
			queryHQL.setParameter("id", id);
			BasseCour ferme = (BasseCour) queryHQL.uniqueResult();
			session.close();
			return ferme;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BasseCour> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from BasseCour");
			List<BasseCour> fermes = queryHQL.list();
			session.close();
			return fermes;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
