package com.example.etudiants.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Etudiant;
public interface EtudiantService {
	


	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(Long id);
	Etudiant getEtudiant(Long id);
	List<Etudiant> getAllEtudiants();
	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
	
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom);
	List<Etudiant> findByNomPrenom (String nom, String prenom);
	List<Etudiant> findByDepartement (Departement departement);
	List<Etudiant> findByDepartementIdDepart(Long idDepart);
	List<Etudiant> findByOrderByNom();
	List<Etudiant> trierEtudiantsNomPrenom ();



}