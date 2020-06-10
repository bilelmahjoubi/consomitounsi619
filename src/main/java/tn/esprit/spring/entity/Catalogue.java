package tn.esprit.spring.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Catalogue implements Serializable {
	
	private static final long serialVersionUID = 6191889173079517027L; 
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcatalog;
	
	private String descriptioncatalog;
	private String name;
	private String libelle;
	
	
	@ManyToOne
	private Shop shop;
	

	public int getIdcatalog() {
		return idcatalog;
	}

	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}

	public String getDescriptioncatalog() {
		return descriptioncatalog;
	}

	public void setDescriptioncatalog(String descriptioncatalog) {
		this.descriptioncatalog = descriptioncatalog;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	
	public Catalogue(String descriptioncatalog, String name, String libelle) {
		super();
		this.descriptioncatalog = descriptioncatalog;
		this.name = name;
		this.libelle = libelle;
	}

	public Catalogue(int idcatalog, String descriptioncatalog, String name, String libelle) {
		super();
		this.idcatalog = idcatalog;
		this.descriptioncatalog = descriptioncatalog;
		this.name = name;
		this.libelle = libelle;
	}

	public Catalogue() {
		super();
	}

	@Override
	public String toString() {
		return "Catalogue [idcatalog=" + idcatalog + ", descriptioncatalog=" + descriptioncatalog + ", name=" + name
				+ ", libelle=" + libelle + "]";
	}

	
	
}
