package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandeRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.PanierRepository;
@Service

public class CommandeService  implements ICommandeService {

	@Autowired
	CommandeRepository commandeRepository; 
	@Autowired
	IPanierService ipanierservice; 
	@Autowired
    ClientRepository clientRepository;
	@Autowired
	PanierRepository  panierRepository; 
	@Autowired
	IFactureService  ifactureservice;
	@Autowired
	FactureRepository factureRepository;

	public Commande  ajouterCommande(Commande commande) {
	return 	commandeRepository.save(commande);
		
	}
	@Override
	public void deleteCommandeById(int commandeid) {
		Commande commandeManagedEntity = commandeRepository.findById(commandeid).get();
		commandeRepository.delete(commandeManagedEntity);

	}
	
	public List<Commande> getAllCommandes() {
		return (List<Commande>) commandeRepository.findAll();
}
	
	public Commande getCommandeById(int idcmd) {
		return commandeRepository.findById(idcmd).get();	
	}
	/*@Override
	public void mettreAjourTypePaiment(String typepaiment,int idcmd) {
		Commande commande = commandeRepository.findById(idcmd).get();
		commande.setTypepaiment(typepaiment);
		commandeRepository.save(commande);
}*/
	
	public int validercommande(int idclient) {
    float total= ipanierservice.gettotal(idclient);
    Commande commande=new Commande();
    commande.setTotal(total);
   // commande.setTypelivraison(null);
    //commande.setTypepaiment(null);
    Date d = new Date();
    System.out.println(d);
    System.out.println(d.getDate()+"/"+d.getMonth()+"/"+d.getYear()+"\t"+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
    commande.setDatecmd(d);
    Client clientManagedEntity = clientRepository.findById(idclient).get();
    commande.setClient(clientManagedEntity);
    commandeRepository.save(commande);
    ipanierservice.diminuerStockProduit(idclient);
    ArrayList<Panier> paniers=(ArrayList<Panier>) panierRepository.getPaniers(idclient);
    for(int i = 0 ; i < paniers.size(); i++) {
    	int ids=paniers.get(i).getIdpanier();
    	panierRepository.deleteById(ids);	
    	//Facture f=new Facture();
        //f.setTypefacture("automatique");
        //int c=f.getIdfacture();
       // int v=commande.getIdcommande();
        ifactureservice.affecterFactureAuCommande(commande.getIdcommande());
       // factureRepository.save(f);
        
    }
    return commande.getIdcommande();
    }
	public List<Commande> getCommandeByClient( int idclient){
		return commandeRepository.getCommandeByClient(idclient);
		
	}
}