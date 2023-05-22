package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IUtilisateurDAO;
import com.inti.entities.Utilisateur;
import com.inti.utils.HibernateUtility;

public class UtilisateurDAO implements IUtilisateurDAO{

	@Override
	public void create(Utilisateur obj) {
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
	public void update(Utilisateur obj) {
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
			String hql = "delete Utilisateur where idUtilisateur = :idUtilisateur";
			Query queryHQL = session.createQuery(hql).setParameter("idUtilisateur", 
					id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		
	}

	@Override
	public Utilisateur getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Utilisateur where idUtilisateur = :idUtilisateur");
			queryHQL.setParameter("idUtilisateur", id);
			Utilisateur agriculteur = (Utilisateur) queryHQL.uniqueResult();
			session.close();
			return agriculteur;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Utilisateur> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Utilisateur");
			List<Utilisateur> agriculteurs = queryHQL.list();
			session.close();
			return agriculteurs;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
