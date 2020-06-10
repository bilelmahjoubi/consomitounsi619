package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Catalogue;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.services.ICatalogueService;

@Controller(value = "icontrollercatalogue")
@Scope(value = "session")
@ELBeanName(value = "icontrollercatalogue")
@Join(path = "/", to = "/login.jsf")
public class IControllerCatalogue {

@Autowired
ICatalogueService icatalogueservice;
private String name;
private String descriptioncatalog;
private String libelle;
		
		public Catalogue ajouterCatalogue(Catalogue catalogue) {
			  return   icatalogueservice.ajouterCatalogue(catalogue);
			 
		}
		
		public void deleteCatalogueById(int idcatalog) {
			icatalogueservice.deleteCatalogueById(idcatalog);
			
		}
		
		public List<Catalogue> getAllCatalogue(){
			return icatalogueservice.getAllCatalogues();
			
		}
		
		public Catalogue getCatalogueeById(int idcatalog) {
			return icatalogueservice.getCatalogueById(idcatalog);
		}
		
		public void mettreAjourDescription(String description,int idcatalog) {
			icatalogueservice.mettreAjourDescription(description, idcatalog);
		}
		
		public void addcatalogue(){
			icatalogueservice.ajouterCatalogue(new Catalogue (descriptioncatalog, name,libelle));	
}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescriptioncatalog() {
			return descriptioncatalog;
		}

		public void setDescriptioncatalog(String descriptioncatalog) {
			this.descriptioncatalog = descriptioncatalog;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public ICatalogueService getIcatalogueservice() {
			return icatalogueservice;
		}

		public void setIcatalogueservice(ICatalogueService icatalogueservice) {
			this.icatalogueservice = icatalogueservice;
		}
		
}
