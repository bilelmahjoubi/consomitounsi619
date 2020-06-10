package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;







@Entity
@Table(name = "Produit")
@JsonIgnoreProperties
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 7950217207447904668L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Prod_Id")
	private int id;
	@NotNull (message="product name is null")
	@Column(name = "Prod_nom")
	private String nom;
	@NotNull
	@Positive(message="The price should be positive number ")
	@Column(name = "Prod_Prix")
	private long prix;
	@Column(name = "Prod_Desc")
	private String Description;
	@Column(name = "Prod_Qount")
	private long quantite;
	@NotNull
	@Positive(message="Poid should be positive number ")
	@Column(name = "Prod_Poid")
	private long poid;
	@Column(name = "Barre_code")
	private long barreCode;
	private String img;
	@Column(name = "Prix_Achat")
	private long prixAchat;
	@Column(name = "Prix_Vente")
	private int prixVente;
	
	


	
	public Produit() {
		super();
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getNom() {
		return nom;
	}





	public void setNom(String nom) {
		this.nom = nom;
	}





	public long getPrix() {
		return prix;
	}





	public void setPrix(long prix) {
		this.prix = prix;
	}





	public String getDescription() {
		return Description;
	}





	public void setDescription(String description) {
		Description = description;
	}





	public long getQuantite() {
		return quantite;
	}





	public void setQuantite(long quantite) {
		this.quantite = quantite;
	}





	public long getPoid() {
		return poid;
	}





	public void setPoid(long poid) {
		this.poid = poid;
	}





	public long getBarreCode() {
		return barreCode;
	}





	public void setBarreCode(long barreCode) {
		this.barreCode = barreCode;
	}





	public String getImg() {
		return img;
	}





	public void setImg(String img) {
		this.img = img;
	}





	public long getPrixAchat() {
		return prixAchat;
	}





	public void setPrixAchat(long prixAchat) {
		this.prixAchat = prixAchat;
	}





	public int getPrixVente() {
		return prixVente;
	}





	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}





	public Produit(int id, @NotNull(message = "product name is null") String nom,
			@NotNull @Positive(message = "The price should be positive number ") long prix, String description,
			long quantite, @NotNull @Positive(message = "Poid should be positive number ") long poid, long barreCode,
			String img, long prixAchat, int prixVente) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		Description = description;
		this.quantite = quantite;
		this.poid = poid;
		this.barreCode = barreCode;
		this.img = img;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
	}
	
	
}




