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
	@JsonIgnore
	@OneToOne(mappedBy="reclamation")
	private Commandes commande_id;  
	@OneToOne(mappedBy="reclamation")
	private User user_id ;
	public Reclamation() {
		super();
	}
	public Reclamation(int id, String description, String etat, String reponse, String titre, Boolean traiter,
			Date date_rec, Date dateT, Commandes commande_id, User user_id) {
		super();
		this.id = id;
		this.description = description;
		this.etat = etat;
		this.reponse = reponse;
		this.titre = titre;
		this.traiter = traiter;
		this.date_rec = date_rec;
		this.dateT = dateT;
		this.commande_id = commande_id;
		this.user_id = user_id;
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
	public Commandes getCommande_id() {
		return commande_id;
	}
	public void setCommande_id(Commandes commande_id) {
		this.commande_id = commande_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	


	
	
	
	
}