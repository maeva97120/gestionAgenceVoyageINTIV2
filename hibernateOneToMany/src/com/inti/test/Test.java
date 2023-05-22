package com.inti.test;

import java.util.List;

import com.inti.entities.Departement;
import com.inti.entities.Societe;
import com.inti.services.impl.DepartementService;
import com.inti.services.impl.SocieteService;
import com.inti.services.interfaces.IDepartementService;
import com.inti.services.interfaces.ISocieteService;

public class Test {

	public static void main(String[] args) {
		IDepartementService departementService = new DepartementService();
		ISocieteService societeService = new SocieteService();
		
		Societe societe1 = new Societe("s1");
		Societe societe2 = new Societe("s2");
		Societe societe3 = new Societe("s3");
		
		societeService.create(societe1);
		societeService.create(societe2);
		societeService.create(societe3);
		
		Departement departement1=new Departement("INFO","Informatique", societe3);
		Departement departement2=new Departement("INFO","Informatique", societe1);
		Departement departement3=new Departement("INFO","Informatique", societe2);
		Departement departement4=new Departement("Compta","Comptabilité", societe2);
		Departement departement5=new Departement("MEC","Mécanique",societe1);
		
		departementService.create(departement1);
		departementService.create(departement2);
		departementService.create(departement3);
		departementService.create(departement4);
		departementService.create(departement5);
		
		System.out.println("Affichage des départements");
		List<Departement> departements=departementService.getAll();
		for (Departement departement : departements) {
			System.out.println(departement.toString());
		}
	}

}
