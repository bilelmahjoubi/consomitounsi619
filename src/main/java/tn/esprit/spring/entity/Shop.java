package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;



@Entity
public class Shop implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idshop;
	private String name;
	private String description;
	private String location;
	
	@OneToMany(mappedBy="shop", cascade = {CascadeType.PERSIST, CascadeType. REMOVE}, fetch=FetchType.EAGER)
	private List<Product> products = new ArrayList<>();
	
	
	 @OneToMany(mappedBy="shop", cascade = {CascadeType.PERSIST, CascadeType. REMOVE}, fetch=FetchType.EAGER)
	private  Set <Catalogue> catalogues  = new HashSet<Catalogue>();
	 
	public int getIdshop() {
		return idshop;
	}
	public void setIdshop(int idshop) {
		this.idshop = idshop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Set<Catalogue> getCatalogues() {
		return catalogues;
	}
	public void setCatalogues(Set<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}
	@Override
	public String toString() {
		return "Shop [idshop=" + idshop + ", name=" + name + ", description=" + description + ", location=" + location
				+ "]";
	}
	
	
	public Shop(int idshop, String name, String description, String location) {
		super();
		this.idshop = idshop;
		this.name = name;
		this.description = description;
		this.location = location;
	}
	
	public Shop() {
		super();
	}
	
}
