package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.dao.interfaces.IAnimalDAO;
import com.inti.entities.Animal;
import com.inti.utils.HibernateUtility;

public class AnimalDAO implements IAnimalDAO{

	@Override
	public void create(Animal obj) {
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
	public void update(Animal obj) {
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
			String hql = "delete Animal where idAnimal = :idAnimal";
			Query queryHQL = session.createQuery(hql).setParameter("idAnimal", 
					id);
			queryHQL.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		
	}

	@Override
	public Animal getById(Long id) {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Animal where idAnimal = :idAnimal");
			queryHQL.setParameter("idAnimal", id);
			Animal animal = (Animal) queryHQL.uniqueResult();
			session.close();
			return animal;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Animal> getAll() {
		Session session = HibernateUtility.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Query queryHQL = session.createQuery(" from Animal");
			List<Animal> animals = queryHQL.list();
			session.close();
			return animals;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
