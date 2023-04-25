package com.example.etudiants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.etudiants.entities.Departement;
import com.example.etudiants.entities.Etudiant;

@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository <Etudiant, Long> {
	
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom);
	
	@Query("select e from Etudiant e where e.nom like %?1 and e.prenom like %?2")
	List<Etudiant> findByNomPrenom (String nom, String prenom);

	@Query("select e from Etudiant e where e.departement = ?1")
	List<Etudiant> findByDepartement (Departement departement);
	
	List<Etudiant> findByDepartementIdDepart(Long idDepart);
	
	List<Etudiant> findByOrderByNom();
	
	@Query("select e from Etudiant e order by e.nom DESC, e.prenom ASC")
	List<Etudiant> trierEtudiantsNomPrenom ();


}
