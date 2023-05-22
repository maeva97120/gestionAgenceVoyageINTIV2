package com.inti.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.inti.entities.Utilisateur;
import com.inti.model.Adresse;
import com.inti.entities.Animal;
import com.inti.entities.BasseCour;
import com.inti.entities.Betail;
import com.inti.entities.Ferme;
import com.inti.entities.Role;
import com.inti.services.impl.UtilisateurService;
import com.inti.services.impl.AnimalService;
import com.inti.services.impl.BasseCourService;
import com.inti.services.impl.BetailService;
import com.inti.services.impl.FermeService;
import com.inti.services.impl.RoleService;
import com.inti.services.interfaces.IUtilisateurService;
import com.inti.services.interfaces.IAnimalService;
import com.inti.services.interfaces.IBasseCourService;
import com.inti.services.interfaces.IBetailService;
import com.inti.services.interfaces.IFermeService;
import com.inti.services.interfaces.IRoleService;

public class Test {

	public static void main(String[] args) throws ParseException {
		IFermeService fermeService = new FermeService();
		IUtilisateurService utilisateurService = new UtilisateurService();
		IRoleService roleService = new RoleService();
		IBasseCourService basseCourService = new BasseCourService();
		IBetailService betailService = new BetailService();
		IAnimalService animalService = new AnimalService();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = simpleDateFormat.parse("25/12/1985");
		Date d2 = simpleDateFormat.parse("12/01/1987");

		Adresse adresse1 = new Adresse("rue1", "37000", "Tours");
		Adresse adresse2 = new Adresse("rue2", "44000", "Nantes");

		Ferme ferme1 = new Ferme("f1", adresse1);
		Ferme ferme2 = new Ferme("f2", adresse2);

		fermeService.create(ferme1);
		fermeService.create(ferme2);

		Role role1 = new Role("agriculteur");
		Role role2 = new Role("admin");
		Role role3 = new Role("responsable");

		roleService.create(role1);
		roleService.create(role2);
		roleService.create(role3);

		Set<Role> roles1 = new HashSet<>();
		roles1.add(role2);
		roles1.add(role3);
		Set<Role> roles2 = new HashSet<>();
		roles2.add(role1);

		Utilisateur utilisateur1 = new Utilisateur("Ayari", "Oussama", "ouss37", "ouss37", 37, d1, ferme1, roles1);
		Utilisateur utilisateur2 = new Utilisateur("Jean", "Paul", "paul35", "paul35", 35, d2, ferme2, roles2);

		utilisateurService.create(utilisateur1);
		utilisateurService.create(utilisateur2);

		System.out.println("***Affichage des utilisateurs***");
		List<Utilisateur> utilisateurs = utilisateurService.getAll();
		for (Utilisateur utilisateur : utilisateurs) {
			System.out.println(utilisateur.toString());
		}
		BasseCour basseCour1 = new BasseCour(false, ferme1, "habitat1");
		BasseCour basseCour2 = new BasseCour(false, ferme1, "habitat1");
		BasseCour basseCour3 = new BasseCour(true, ferme2, "habitat2");
		Betail betail1 = new Betail(true, ferme2, "tech1");
		Betail betail2 = new Betail(false, ferme1, "tech2");

		basseCourService.create(basseCour1);
		basseCourService.create(basseCour2);
		basseCourService.create(basseCour3);

		betailService.create(betail1);
		betailService.create(betail2);

		System.out.println("***Affichage des animaux***");
		List<Animal> animaux = animalService.getAll();
		for (Animal animal : animaux) {
			System.out.println(animal.toString());
		}

	}

}
