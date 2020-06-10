package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Commande  implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcommande;
	//private String typepaiment;
	private Date datecmd;
	private float total;
	//private String typelivraison;
	
	
	
	
	@OneToOne
	private Facture facture;
	
	@ManyToOne
	private Client client;
	
	
	
	
	public int getIdcommande() {
		return idcommande;
	}
	public void setIdcommande(int idcommande) {
		this.idcommande = idcommande;
	}
	/*public String getTypepaiment() {
		return typepaiment;
	}
	public void setTypepaiment(String typepaiment) {
		this.typepaiment = typepaiment;
	}*/
	@Temporal(TemporalType.DATE)
	public Date getDatecmd() {
		return datecmd;
	}
	public void setDatecmd(Date datecmd) {
		this.datecmd = datecmd;
	}
	
	
	
	
	
	/*public String getTypelivraison() {
		return typelivraison;
	}
	public void setTypelivraison(String typelivraison) {
		this.typelivraison = typelivraison;
	}*/
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Commande(int idcommande ,Date datecmd, float total) {
		super();
		this.idcommande = idcommande;
		//this.typepaiment = typepaiment;
		this.datecmd = datecmd;
		this.total = total;
		//this.typelivraison = typelivraison;
	}
	public Commande() {
		super();
	}
	@Override
	public String toString() {
		return "Commande [idcommande=" + idcommande + ", datecmd=" + datecmd + ", total=" + total + "]";
	}
	
	
	
	
	
	
	

}
