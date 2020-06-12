package tn.esprit.spring.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IClientService;


@Scope(value = "session")
@ELBeanName(value = "icontrollerclient")
@Join(path = "/", to = "/login.jsf")
@Controller(value = "icontrollerclient")
public class IControllerClient {
	@Autowired
	IClientService iclientservice;
	private String login; 
	private String password; 
	private Client client;
	public static  Boolean loggedIn;
	private int id;
	

	
	public Client ajouterClient(Client client) {
		return iclientservice.ajouterClient(client);
		
	}
	public Client getClientById(int idclient) {
		return iclientservice.getClientById(idclient);
	}
	
	public String dologin() {
        
		String navigateTo = "null";
		Client client=iclientservice.getClientByLoginAndPassword(login,password);
		if (client != null && client.getRole() == Role.ADMINISTRATEUR) {
		navigateTo = "/welcome.xhtml?faces-redirect=true";
		loggedIn = true;
		
		}
		else if (client != null && client.getRole() == Role.CLIENT) {
			navigateTo = "/welcomeclient.xhtml?faces-redirect=true";
			loggedIn = true;
			id=client.getIdclient();
		}
		else
		{
		FacesMessage facesMessage =
		                new FacesMessage("Login Failed: please check your username/password and try again.");
		            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		
		}
	
	
	
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
		
	
	public IClientService getIclientservice() {
		return iclientservice;
	}
	public void setIclientservice(IClientService iclientservice) {
		this.iclientservice = iclientservice;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
