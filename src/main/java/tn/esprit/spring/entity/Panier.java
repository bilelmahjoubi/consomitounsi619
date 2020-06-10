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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier   implements Serializable {
	
		
		private static final long serialVersionUID = 6191889173079517027L; 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpanier;
	
	private int nbrproduits;
	
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;

	
	//@OneToMany(mappedBy="panier",fetch=FetchType.EAGER)
	//private	List<Product> products= new ArrayList<Product>();
	@ManyToMany 
	private List<Product> products;
	
	
	public int getIdpanier() {
		return idpanier;
	}

	public void setIdpanier(int idpanier) {
		this.idpanier = idpanier;
	}

	public int getNbrproduits() {
		return nbrproduits;
	}

	public void setNbrproduits(int nbrproduits) {
		this.nbrproduits = nbrproduits;
	}
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
		
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Panier() {
		super();
	}

	@Override
	public String toString() {
		return "Panier [idpanier=" + idpanier + ", nbrproduits=" + nbrproduits + "]";
	}

	public Panier(int idpanier, Client client, List<Product> products) {
		super();
		this.idpanier = idpanier;
		this.client = client;
		this.products = products;
	}

	
	

	public Panier(Client client, List<Product> products) {
		super();
		this.client = client;
		this.products = products;
	}

	
	
	
	
	
	
	
	
}
