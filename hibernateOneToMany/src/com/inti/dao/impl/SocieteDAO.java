package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.ISocieteDAO;
import com.inti.entities.Societe;
import com.inti.utils.HibernateUtility;

public class SocieteDAO implements ISocieteDAO {

	@Override
	public void create(Societe obj) {
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
	public void update(Societe obj) {
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
			String hql = "delete Societe where idSociete = :idSociete";
			Query queryHQL = session.createQuery(hql).setParameter("idSociete", id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Societe getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Societe where idSociete = :idSociete");
			queryHQL.setParameter("idSociete", id);
			Societe societe = (Societe) queryHQL.uniqueResult();
			return societe;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Societe> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Societe");
			List<Societe> societes = queryHQL.list();
			return societes;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}



}
