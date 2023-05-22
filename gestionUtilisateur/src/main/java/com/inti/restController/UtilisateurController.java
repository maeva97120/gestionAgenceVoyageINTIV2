package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IUtilisateurService;

@RestController // RestFul ws
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;

	@RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "utilisateurs/{idOussama}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("idOussama") Long id) {
		return utilisateurService.findOne(id);
	}

	// html : formulaire ( navigateur : format = text) <=> serveur web : requête
	// http (body : format : json) <=> gestionUtilisateur(json <-> java) <=> jdbc
	// (java <--> sql)
	@RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}

	@RequestMapping(value = "utilisateurs/{idOussama}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("idOussama") Long id) {
		utilisateurService.delete(id);
	}

	@RequestMapping(value = "utilisateurs/{idOussama}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("idOussama") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(id);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setRoles(utilisateur.getRoles());
		return utilisateurService.save(currentUtilisateur);
	}

}
