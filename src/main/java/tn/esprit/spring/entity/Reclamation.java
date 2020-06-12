package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 

	private String description ;
	private String etat;
	private String reponse  ;
	private String titre  ;
	private Boolean traiter ;
	@Temporal(TemporalType.DATE)
	private Date date_rec ;
	@Temporal(TemporalType.DATE)
	private Date dateT;


	public Reclamation() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Boolean getTraiter() {
		return traiter;
	}
	public void setTraiter(Boolean traiter) {
		this.traiter = traiter;
	}
	public Date getDate_rec() {
		return date_rec;
	}
	public void setDate_rec(Date date_rec) {
		this.date_rec = date_rec;
	}
	public Date getDateT() {
		return dateT;
	}
	public void setDateT(Date dateT) {
		this.dateT = dateT;
	}


	


	
	
	
	
}