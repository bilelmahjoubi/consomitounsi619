package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Publicite {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_P")
	private int id ;

	private String canal; 

	private int cout; 

	@Temporal(TemporalType.DATE)
	private Date date_debut; 

	@Temporal(TemporalType.DATE)
	private Date date_fin ;

	private int nbr_final_vue; 

	private int nbr_initial_vue_cible ;

	private String nom; 

	private String gender_cible ;

	private int debut_age_cible; 

	private int fin_age_cible ;
	
	@JsonIgnore
	@OneToOne(mappedBy="publicite")
	private User id_user;
	
	@OneToOne
	private Event event;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getNbr_final_vue() {
		return nbr_final_vue;
	}

	public void setNbr_final_vue(int nbr_final_vue) {
		this.nbr_final_vue = nbr_final_vue;
	}

	public int getNbr_initial_vue_cible() {
		return nbr_initial_vue_cible;
	}

	public void setNbr_initial_vue_cible(int nbr_initial_vue_cible) {
		this.nbr_initial_vue_cible = nbr_initial_vue_cible;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGender_cible() {
		return gender_cible;
	}

	public void setGender_cible(String gender_cible) {
		this.gender_cible = gender_cible;
	}

	public int getDebut_age_cible() {
		return debut_age_cible;
	}

	public void setDebut_age_cible(int debut_age_cible) {
		this.debut_age_cible = debut_age_cible;
	}

	public int getFin_age_cible() {
		return fin_age_cible;
	}

	public void setFin_age_cible(int fin_age_cible) {
		this.fin_age_cible = fin_age_cible;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Publicite(int id, String canal, int cout, Date date_debut, Date date_fin, int nbr_final_vue,
			int nbr_initial_vue_cible, String nom, String gender_cible, int debut_age_cible, int fin_age_cible,
			User id_user, Event event) {
		super();
		this.id = id;
		this.canal = canal;
		this.cout = cout;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nbr_final_vue = nbr_final_vue;
		this.nbr_initial_vue_cible = nbr_initial_vue_cible;
		this.nom = nom;
		this.gender_cible = gender_cible;
		this.debut_age_cible = debut_age_cible;
		this.fin_age_cible = fin_age_cible;
		this.id_user = id_user;
		this.event = event;
	}

	public Publicite() {
		super();
	}
	
	


}
