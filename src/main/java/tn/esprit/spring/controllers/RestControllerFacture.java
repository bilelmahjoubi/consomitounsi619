package tn.esprit.spring.controller;

import java.util.List;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.services.ICommandeService;
import tn.esprit.spring.services.IFactureService;

@RestController
public class RestControllerFacture {
	@Autowired
	IFactureService ifactureservice;
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterFacture
		
		@PostMapping("/ajouterFacture")
		@ResponseBody
		public Facture ajouterFacture(@RequestBody Facture facture)
		{
			ifactureservice.ajouterFacture(facture);
		return facture;
		}
	
		// URL : http://localhost:8081/SpringMVC/servlet/deleteFactureById/1
	    @DeleteMapping("/deleteFactureById/{factureId}") 
		@ResponseBody 
		public void deleteFactureById(@PathVariable("factureId")int factureId) {
			ifactureservice.deleteFactureById(factureId);
}
	 // URL : http://localhost:8081/SpringMVC/servlet/getAllFactures
		@GetMapping(value = "/getAllFactures")
	    @ResponseBody
	    public List<Facture> getAllFactures(){
			return ifactureservice.getAllfactures();   
	    }    
		
		// URL : http://localhost:8081/SpringMVC/servlet/getFactureById/1
		   @GetMapping(value = "getFactureById/{idfacture}")
		   @ResponseBody
		public Facture getFactureById(@PathVariable("idfacture")int idfacture) {
			return ifactureservice.getFactureById(idfacture);
		}  
		// Modifier typePaiment : http://localhost:8081/SpringMVC/servlet/modifyTypeFacture/newtypefac/1
			@PutMapping(value = "/modifyTypeFacture/{newtypefac}/{idfacture}") 
			@ResponseBody
		   public void mettreAjourTypeFacture(@PathVariable("newtypefac")String newtypefac,@PathVariable("idfacture")int idfacture) {
				ifactureservice.mettreAjourTypeFacture(newtypefac, idfacture);
			}
			// http://localhost:8081/SpringMVC/servlet/affecterFactureAuCommande/1
			@PutMapping(value = "/affecterFactureAuCommande/{idcommande}") 
			public void affecterFactureAuCommande(@PathVariable("idcommande")int idcommande) {
				ifactureservice.affecterFactureAuCommande( idcommande);	
			}
			// URL : http://localhost:8081/SpringMVC/servlet/getFactureByClient/1
			   @GetMapping(value = "getFactureByClient/{idclient}")
			   @ResponseBody
			public List<Facture> getFactureByClient(@PathVariable("idclient") int  idclient){
				return ifactureservice.getFactureByClient(idclient);
			}
}