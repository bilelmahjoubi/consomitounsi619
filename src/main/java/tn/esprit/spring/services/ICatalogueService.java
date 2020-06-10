package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Catalogue;


public interface ICatalogueService {

	public Catalogue ajouterCatalogue(Catalogue catalogue);
	public void  deleteCatalogueById(int idcatalog);
	public List<Catalogue> getAllCatalogues();
	public Catalogue getCatalogueById(int  idcatalog);
	public void mettreAjourDescription(String description,int idcatalog); 
}
