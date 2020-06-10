package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.IClientService;
import tn.esprit.spring.services.IFactureService;
import tn.esprit.spring.services.IPanierService;
@RestController
public class RestControllerPanier {
	
	@Autowired
	IPanierService ipanierservice;
	@Autowired
	IClientService iclientservice;	
	// http://localhost:8081/SpringMVC/servlet/ajouterPanier
	
			//@PostMapping("/ajouterPanier")
		//	@ResponseBody
			//public Panier ajouterPanier(@RequestBody Panier panier)
			//{
				//ipanierservice.ajouterPanier(panier);
			//return panier;
			//}
	// http://localhost:8081/SpringMVC/servlet/ajouterProduitPanier/1/1
				@PutMapping(value = "/ajouterProduitPanier/{idproduct}/{idclient}") 
				public void ajouterProduitPanier( @PathVariable("idproduct")int idproduct,@PathVariable("idclient")int idclient) {
					ipanierservice.ajouterProduitPanier(idproduct, idclient);
					
				}
				
				// URL : http://localhost:8081/SpringMVC/servlet/getAllPaniers
				@GetMapping(value = "/getAllPaniers")
			    @ResponseBody
			    public List<Panier> getAllPaniers(){
					return ipanierservice.getAllPaniers();
			    }  
  //http://localhost:8081/SpringMVC/servlet/getClientName/1
			    @GetMapping(value = "getClientName/{idclient}")
			    @ResponseBody
				public List<String> getClientName(@PathVariable("idclient") int  idclient){
			      return  	ipanierservice.getClientName(idclient);
			    	
				}
	 
//http://localhost:8081/SpringMVC/servlet/getProds/1
			    @GetMapping(value = "getProds/{idclient}")
			    @ResponseBody
			    public List<Product> getProds(@PathVariable("idclient") int  idclient){
			      return  	ipanierservice.getProds(idclient);
}
			    
 //http://localhost:8081/SpringMVC/servlet/gettotal/1
			    @GetMapping(value = "gettotal/{idclient}")
			    @ResponseBody
			    public float gettotal(@PathVariable("idclient") int  idclient){
			      return  	ipanierservice.gettotal(idclient);
}
			    
//http://localhost:8081/SpringMVC/servlet/diminuerStockProduit/1
			    @GetMapping(value = "diminuerStockProduit/{idclient}")
			    @ResponseBody
			    public float diminuerStockProduit(@PathVariable("idclient") int  idclient){
			      return  	ipanierservice.diminuerStockProduit(idclient);
}
			  //http://localhost:8081/SpringMVC/servlet/getPaniers/1
			    @GetMapping(value = "getPaniers/{idclient}")
			    @ResponseBody
			    public List<Panier> getPaniers( @PathVariable("idclient") int  idclient){
			    	 return  	ipanierservice.getPaniers(idclient);
			    }
 // URL : http://localhost:8081/SpringMVC/servlet/deletePanierById/1
			    @DeleteMapping("/deletePanierById/{idpanier}") 
				@ResponseBody 
				 public void deletePanierById(@PathVariable("idpanier")int idpanier) {
			    	ipanierservice.deletePanierById(idpanier);
}
}

			    
