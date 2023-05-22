package com.inti.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory sf;
	
	private HibernateUtility() {
		
	}
	// synchronized : algorithme d'ordonnancement : LIFO : last in first out / FIFO : first in first out
	public static synchronized SessionFactory getSessionFactory() {
		if(sf == null) {
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
}
