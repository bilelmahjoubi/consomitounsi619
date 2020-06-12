package tn.esprit.spring.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.services.ICommandeService;



@RestController
public class RestControllerCommande {
@Autowired
	ICommandeService icommandeservice;
	// http://localhost:8081/SpringMVC/servlet/
		//@RequestMapping("/")
		//@ResponseWrapper
			//public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web Services REST."; }
	
	// http://localhost:8081/SpringMVC/servlet/ajouterCommande
		
		@PostMapping("/ajouterCommande")
		@ResponseBody
		public Commande ajouterCommande(@RequestBody Commande commande)
		{
			icommandeservice.ajouterCommande(commande);
		return commande;
		}
	
		// URL : http://localhost:8081/SpringMVC/servlet/deleteCommandeById/1
	    @DeleteMapping("/deleteCommandeById/{idcommande}") 
		@ResponseBody 
		public void deleteCommandeById(@PathVariable("idcommande")int commandeid) {
			icommandeservice.deleteCommandeById(commandeid);
}
	 // URL : http://localhost:8081/SpringMVC/servlet/getAllCommandes
		@GetMapping(value = "/getAllCommandes")
	    @ResponseBody
	    public List<Commande> getAllCommandes(){
			return icommandeservice.getAllCommandes();    
	    }    
		
		// URL : http://localhost:8081/SpringMVC/servlet/getCommandeById/1
		   @GetMapping(value = "getCommandeById/{idcommande}")
		   @ResponseBody
		public Commande getCommandeById(@PathVariable("idcommande")int idcmd) {
			return icommandeservice.getCommandeById(idcmd);
		}  
		// Modifier typePaiment : http://localhost:8081/SpringMVC/servlet/modifyTypePaiment/newTypePaiment/1
			/*@PutMapping(value = "/modifyTypePaiment/{newTypePaiment}/{idcmd}") 
			@ResponseBody
		   public void mettreAjourTypePaiment(@PathVariable("newTypePaiment")String typepaiment,@PathVariable("idcmd")int idcmd) {
				icommandeservice.mettreAjourTypePaiment(typepaiment, idcmd);
			}
			*/
	// http://localhost:8081/SpringMVC/servlet/validercommande/1
			@PutMapping(value = "/validercommande/{idclient}") 
			public void validercommande(@PathVariable("idclient") int  idclient) {
			 	icommandeservice.validercommande(idclient);	
			}
	// URL : http://localhost:8081/SpringMVC/servlet/getCommandeByClient/1
			   @GetMapping(value = "getCommandeByClient/{idclient}")
			   @ResponseBody
			public List<Commande> getCommandeByClient( @PathVariable("idclient") int  idclient){
				return icommandeservice.getCommandeByClient(idclient);
			}
			   
			   
			   
}
