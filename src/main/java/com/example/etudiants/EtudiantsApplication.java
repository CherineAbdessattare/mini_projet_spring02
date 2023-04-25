package com.example.etudiants;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.etudiants.entities.Etudiant;
import com.example.etudiants.service.EtudiantService;

@SpringBootApplication
public class EtudiantsApplication implements CommandLineRunner {
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(EtudiantsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//etudiantService.saveEtudiant(new Etudiant("Dalel","Loussaief",new Date(),"DSI","dalelloussaief@gmail.com"));
	//etudiantService.saveEtudiant(new Etudiant("Nour ","Garaali",new Date(),"DSI","nourgaraali@gmail.com"));
	//etudiantService.saveEtudiant(new Etudiant("Mohammed","Ali",new Date(),"GM","dalelloussaief@gmail.com"));
	//etudiantService.saveEtudiant(new Etudiant("Azize","Abdessattare",new Date(),"GC","nourgaraali@gmail.com"));
		repositoryRestConfiguration.exposeIdsFor(Etudiant.class);

	}

}
