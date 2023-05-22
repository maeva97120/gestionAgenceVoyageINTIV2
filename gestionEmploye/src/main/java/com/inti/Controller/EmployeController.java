package com.inti.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Employe;
import com.inti.services.interfaces.IEmployeService;

@RestController
public class EmployeController {
	@Autowired
	IEmployeService employeService;
	
	@RequestMapping(value = "employes", method = RequestMethod.GET)
	public List<Employe> findAll() {
		return employeService.findAll();
	}
	@RequestMapping(value = "employes/{idLucas}")
	public Employe findOne(@PathVariable("idLucas") Long id) {
		return employeService.findOne(id);
	}

	@RequestMapping(value = "employes", method = RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe employe) {
		return employeService.save(employe);
	}

	@RequestMapping(value = "employes/{idLucas}", method = RequestMethod.DELETE)
	public void deleteEmploye(@PathVariable("idLucas") Long id) {
		employeService.delete(id);
	}
	
	@RequestMapping(value = "employes/{idLucas}", method = RequestMethod.PUT)
	public Employe updateEmploye(@PathVariable("idLucas") Long id, @RequestBody Employe employe) {
		Employe currentEmploye = employeService.findOne(id);
		currentEmploye.setNomEmploye(employe.getNomEmploye());
		currentEmploye.setPrenomEmploye(employe.getPrenomEmploye());
		currentEmploye.setFonction(employe.getFonction());
		return employeService.save(currentEmploye);
	}
}
