package tn.esprit.spring.services;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import tn.esprit.spring.entities.Commande;

import tn.esprit.spring.entities.Facture;

import tn.esprit.spring.repository.CommandeRepository;
import tn.esprit.spring.repository.FactureRepository;

@Service
public class FactureService implements IFactureService {

	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	@Override
	public List<Facture> getAllfactures() {
		return (List<Facture>) factureRepository.findAll();

}
	@Override
	public Facture ajouterFacture(Facture facture) {
		return factureRepository.save(facture);
	
	}
	
	@Transactional
	public void affecterFactureAuCommande( int idcommande) {
		Facture f=new Facture();
		f.setTypefacture("Automatique");
		//Facture factureManagedEntity = factureRepository.findById(idfacture).get();
		Commande commandeManagedEntity = commandeRepository.findById(idcommande).get();
		//factureManagedEntity.setCommande(commandeManagedEntity);
		f.setCommande(commandeManagedEntity);
		//factureRepository.save(factureManagedEntity);
		factureRepository.save(f);
		
	}
	
	@Override
	public void deleteFactureById(int factureId) {
		Facture factureManagedEntity = factureRepository.findById(factureId).get();
		factureRepository.delete(factureManagedEntity);

	}
	
	@Override
	public void mettreAjourTypeFacture(String newtypefac,int idfacture) {
		Facture facture = factureRepository.findById(idfacture).get();
		facture.setTypefacture(newtypefac);
		factureRepository.save(facture);

	}
	@Override
	public Facture getFactureById(int idfacture) {
		return factureRepository.findById(idfacture).get();	
	}
	
	 public List<Facture> getFactureByClient(int idclient){
		 return factureRepository.getFactureByClient(idclient);
	 }
	 
	 public void updateFacture(Facture f) {
		 factureRepository.save(f);
		 }
	 
	 /*private static void generatePDFFromHTML(String filename) throws DocumentException, IOException {
		    Document document = new Document();
		    PdfWriter writer = PdfWriter.getInstance(document,
		      new FileOutputStream("src/output/html.pdf"));
		    document.open();
		    XMLWorkerHelper.getInstance().parseXHtml(writer, document,
		      new FileInputStream(filename));
		    document.close();
		}*/
	}
		
