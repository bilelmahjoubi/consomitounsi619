package tn.esprit.spring.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itextpdf.html2pdf.HtmlConverter;

import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.ICommandeService;

@Scope(value = "session")
@ELBeanName(value = "icontrollercommande")
@Join(path = "/", to = "/login.jsf")
@Controller(value = "icontrollercommande")
public class IControllerCommande {
	@Autowired
	ICommandeService icommandeservice; 
	   
	     
	  	private  List<Commande> commandes; 
	  	 private int idcmd;
	      
	
	public Commande ajouterCommande(Commande commande) {
		  return   icommandeservice.ajouterCommande(commande);
		 
	}
	
	public void deleteCommandeById(int commandeid) {
		icommandeservice.deleteCommandeById(commandeid);
		
	}
	
	public List<Commande> getAllCommandes(){
		return icommandeservice.getAllCommandes();
		
	}
	
	public Commande getCommandeById(int idcmd) {
		return icommandeservice.getCommandeById(idcmd);
	}
	
	/*public void mettreAjourTypePaiment(String typepaiment,int idcmd) {
		icommandeservice.mettreAjourTypePaiment(typepaiment, idcmd);
	}*/
	
	public int validercommande(int idclient) {
		return  icommandeservice.validercommande(idclient);
		 
	}
	public List<Commande> getCommandeByClient( int idclient){
		return icommandeservice.getCommandeByClient(idclient);
	}
	
	

	public ICommandeService getIcommandeservice() {
		return icommandeservice;
	}

	public void setIcommandeservice(ICommandeService icommandeservice) {
		this.icommandeservice = icommandeservice;
	}

	

	public List<Commande> getCommandes() {
		commandes=icommandeservice.getAllCommandes();
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public int getIdcmd() {
		return idcmd;
	}

	public void setIdcmd(int idcmd) {
		this.idcmd = idcmd;
	}
	
	
	
	
   
}
