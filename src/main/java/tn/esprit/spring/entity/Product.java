package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Product  implements Serializable {
	private static final long serialVersionUID = 6191889143077417027L; 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprod;
	@Column(name="name")
	private String nameprod;
	
	private String description;
	private float price;
	private float quantity;
	@Temporal(TemporalType.DATE)
	private Date fabrication;
	@Temporal(TemporalType.DATE)
	private Date expiration;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Category category;
	private String image;
	
	
	
	@ManyToMany (mappedBy="products")
	private List<Panier> paniers;
	

	//@ManyToOne
	//@JoinColumn(name="idpanier")
	//private Panier panier;
	@ManyToOne
	private Shop  shop;
	
	
	public int getIdprod() {
		return idprod;
	}
	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}
	public String getName() {
		return nameprod;
	}
	public void setName(String nameprod) {
		this.nameprod = nameprod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Date getFabrication() {
		return fabrication;
	}
	public void setFabrication(Date fabrication) {
		this.fabrication = fabrication;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getNameprod() {
		return nameprod;
	}
	public void setNameprod(String nameprod) {
		this.nameprod = nameprod;
	}
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
		
	
	
	public Product(int idprod, String nameprod, String description, float price, float quantity, Date fabrication,
			Date expiration, @NotNull Category category, String image) {
		super();
		this.idprod = idprod;
		this.nameprod = nameprod;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.fabrication = fabrication;
		this.expiration = expiration;
		this.category = category;
		this.image = image;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [idprod=" + idprod + ", nameprod=" + nameprod + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + ", fabrication=" + fabrication + ", expiration=" + expiration +"]";
	}
	

}
