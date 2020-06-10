package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.IPanierService;

@Scope(value = "session")
@ELBeanName(value = "ipaniercontroller")
@Join(path = "/", to = "/login.jsf")
@Controller(value = "ipaniercontroller")
public class IControllerPanier {
	@Autowired
	IPanierService ipanierservice;
	
	
	
	
	public void ajouterProduitPanier(int idproduct,int idclient) {
		ipanierservice.ajouterProduitPanier(idproduct, idclient);
	}
	
	
	
	public List<Panier> getAllPaniers(){
		return ipanierservice.getAllPaniers();
	}
	
	public List<String> getClientName(int  idclient){
		return ipanierservice.getClientName(idclient);
	}
	
	
	public List<Product> getProds( int idclient){
		return ipanierservice.getProds(idclient);
	}
	 public float gettotal(int idclient) {
		 return ipanierservice.gettotal(idclient);
	 }
	 
	 public float diminuerStockProduit(int idclient) {
		 return ipanierservice.diminuerStockProduit(idclient);
	 }
	 public List<Panier> getPaniers( int idclient){
		 return ipanierservice.getPaniers(idclient);
		 
	 }
	 public void deletePanierById(int idpanier) {
		 ipanierservice.deletePanierById(idpanier);
	 }
	 
	
	public IPanierService getIpanierservice() {
		return ipanierservice;
	}

	public void setIpanierservice(IPanierService ipanierservice) {
		this.ipanierservice = ipanierservice;
	}



	



	

	

	


	






	
}

	

	

	

	
	

	
	 


