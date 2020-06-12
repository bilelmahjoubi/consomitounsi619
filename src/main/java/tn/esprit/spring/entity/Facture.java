package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Facture implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L; 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfacture;
	private String typefacture;
	private String name;
	private String surname;
	private String tel;
	private String adresse;
	private float total;
	private Date datefac;
	private Integer factureIdToBeUpdated;
	
	
	
	@OneToOne
	private Commande commande;
	
	
	
	public int getIdfacture() {
		return idfacture;
	}
	public void setIdfacture(int idfacture) {
		this.idfacture = idfacture;
	}
	public String getTypefacture() {
		return typefacture;
	}
	public void setTypefacture(String typefacture) {
		this.typefacture = typefacture;
	}

		
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	

		public Facture(int idfacture, String typefacture) {
		super();
		this.idfacture = idfacture;
		this.typefacture = typefacture;
	}
	
	public Facture() {
		super();
	}
	@Override
	public String toString() {
		return "Facture [idfacture=" + idfacture + ", typefacture=" + typefacture + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getDatefac() {
		return datefac;
	}
	public void setDatefac(Date datefac) {
		this.datefac = datefac;
	}
	
	
	
	public Integer getFactureIdToBeUpdated() {
		return factureIdToBeUpdated;
	}
	public void setFactureIdToBeUpdated(Integer factureIdToBeUpdated) {
		this.factureIdToBeUpdated = factureIdToBeUpdated;
	}
	public Facture(String typefacture, String name, String surname, String tel, String adresse, float total,
			Date datefac) {
		super();
		this.typefacture = typefacture;
		this.name = name;
		this.surname = surname;
		this.tel = tel;
		this.adresse = adresse;
		this.total = total;
		this.datefac = datefac;
	}
	public Facture(String typefacture, String name, String surname, String tel, String adresse, float total,
			Date datefac, Integer factureIdToBeUpdated) {
		super();
		this.typefacture = typefacture;
		this.name = name;
		this.surname = surname;
		this.tel = tel;
		this.adresse = adresse;
		this.total = total;
		this.datefac = datefac;
		this.idfacture = factureIdToBeUpdated;
	}
	public Facture(int idfacture, String typefacture, Commande commande) {
		super();
		this.idfacture = idfacture;
		this.typefacture = typefacture;
		this.commande = commande;
	}
	public Facture(String typefacture, Commande commande) {
		super();
		this.typefacture = typefacture;
		this.commande = commande;
	}
	
	
	
	
}
