package com.example.etudiants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.service.EtudiantService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;


@Controller
public class EtudiantController {
	
	@Autowired
	EtudiantService etudiantService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("etudiant", new Etudiant());
	modelMap.addAttribute("mode", "new");
	return "formEtudiant";
	}

	
	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@Valid Etudiant etudiant,
			BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formEtudiant";
		etudiantService.saveEtudiant(etudiant);
		return "formEtudiant";
		}
	
	@RequestMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEtudiants";
		}
	
	@RequestMapping("/supprimerEtudiant")
	public String supprimerProduit(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{ 
		etudiantService.deleteEtudiantById(id);
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page,size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
		}
	
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Etudiant e= etudiantService.getEtudiant(id);
	modelMap.addAttribute("etudiant", e);
	modelMap.addAttribute("mode", "edit");
	return "formEtudiant";
	}
	
	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateInscription = dateformat.parse(String.valueOf(date));
		 etudiant.setDateInscription(dateInscription);
		 
		 etudiantService.updateEtudiant(etudiant);
		 List<Etudiant> etuds = etudiantService.getAllEtudiants();
		 modelMap.addAttribute("etudiants", etuds);
		return "listeEtudiants";
		}


}
