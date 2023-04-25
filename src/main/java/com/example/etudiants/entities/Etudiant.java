package com.example.etudiants.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nom;
	
	@NotNull
	@Size (min = 3,max = 15)
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateInscription;
	
	@NotNull
	@Size (min = 1,max = 6)
	private String parcours;
	
	@NotNull
	@Size (min = 10,max = 20)
	private String Email;
	
	@ManyToOne
	private Departement departement;
	
	

	public Etudiant(String nom, String prenom, Date dateInscription, String parcours, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.parcours = parcours;
		Email = email;
	}
	
	public Etudiant() {
		super();
	}
	
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDateInscription() {
		return dateInscription;
	}
	
	
	public String getParcours() {
		return parcours;
	}
	
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateInscription + ", parcours=" + parcours + ", Email=" + Email + "]";
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
		
	}
	

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	

}
