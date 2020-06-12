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

import tn.esprit.spring.entities.Catalogue;
import tn.esprit.spring.services.ICatalogueService;

@RestController
public class RestControllerCatalogue {
	@Autowired
	ICatalogueService icatalogueservice;
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterCatalogue
		
		@PostMapping("/ajouterCatalogue")
		@ResponseBody
		public Catalogue ajouterCatalogue (@RequestBody Catalogue catalogue)
		{
			icatalogueservice.ajouterCatalogue(catalogue);
		return catalogue;
		}
	
		// URL : http://localhost:8081/SpringMVC/servlet/deleteCatalogueById/1
	    @DeleteMapping("/deleteCatalogueById/{idcatalog}") 
		@ResponseBody 
		public void deleteCatalogueById(@PathVariable("idcatalog")int idcatalog) {
			icatalogueservice.deleteCatalogueById(idcatalog);
}
	 // URL : http://localhost:8081/SpringMVC/servlet/getAllCatalogues
		@GetMapping(value = "/getAllCatalogues")
	    @ResponseBody
	    public List<Catalogue> getAllCatalgues(){
			return icatalogueservice.getAllCatalogues(); 
	    }    
		
		// URL : http://localhost:8081/SpringMVC/servlet/getCatalogueById/1
		   @GetMapping(value = "getCatalogueById/{idcatalog}")
		   @ResponseBody
		public Catalogue getCatalogueById(@PathVariable("idcatalog")int idcatalog) {
			return icatalogueservice.getCatalogueById(idcatalog);
		}  
		// Modifier description: http://localhost:8081/SpringMVC/servlet/modifyDescription/newDescription/1
			@PutMapping(value = "/modifyDescription/{newDescription}/{idcatalog}") 
			@ResponseBody
		   public void mettreAjourDescription(@PathVariable("newDescription")String description,@PathVariable("idcatalog")int idcatalog) {
				icatalogueservice.mettreAjourDescription(description, idcatalog);
			}
}