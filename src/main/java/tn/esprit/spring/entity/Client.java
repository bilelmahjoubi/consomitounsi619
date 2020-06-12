package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="client")

public class Client  implements Serializable {
	
	private static final long serialVersionUID = 6191889173079517027L; 
	
	
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idclient;
	private String login;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;
	private String lastname;
	private String telephone;
	private String email;
	private String adresse;
	
	@OneToMany(mappedBy="client",fetch=FetchType.EAGER)
	private  //Set <Panier> paniers  = new HashSet<Panier>();
	List<Panier> paniers= new ArrayList<Panier>();
	
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	private Set <Commande> commandes  = new HashSet<Commande>();
	
	
	
	
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/*
	public Set<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	} */
	
	
	
	
	
	public Set<Commande> getCommandes() {
		return commandes;
	}
	
	
	public List<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	

	public Client(int idclient, String login, String password, String name, @NotNull Role role, String lastname,
			String telephone, String email, String adresse) {
		super();
		this.idclient = idclient;
		this.login = login;
		this.password = password;
		this.name = name;
		this.role = role;
		this.lastname = lastname;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
	}
	public Client() {
		super();
	}
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", name=" + name + ", lastname=" + lastname + ", telephone=" + telephone
				+ ", email=" + email + ", adresse=" + adresse + "]";
	}
	
}
