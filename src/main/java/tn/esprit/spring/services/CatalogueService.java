package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Catalogue;
import tn.esprit.spring.repository.CatalogueRepository;

@Service
public class CatalogueService  implements ICatalogueService {

	 @Autowired
	CatalogueRepository catalogueRepository; 

	public Catalogue ajouterCatalogue(Catalogue catalogue) {
	return 	 catalogueRepository.save(catalogue);
		
	}
	
	public void deleteCatalogueById(int idcatalog) {
		Catalogue catalogueManagedEntity = catalogueRepository.findById(idcatalog).get();
		catalogueRepository.delete(catalogueManagedEntity);

	}
	
	public List<Catalogue> getAllCatalogues() {
		return (List<Catalogue>) catalogueRepository.findAll();
}
	
	public Catalogue getCatalogueById(int idcatalog) {
		return catalogueRepository.findById(idcatalog).get();	
	}
	
	public void mettreAjourDescription(String description,int idcatalog) {
		Catalogue catalogue = catalogueRepository.findById(idcatalog).get();
		catalogue.setDescriptioncatalog(description);
		catalogueRepository.save(catalogue);
}
	


}
