package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Facture;
@Service
public interface IFactureService {
	 public List<Facture> getAllfactures() ;
	public Facture ajouterFacture(Facture facture);
	public void affecterFactureAuCommande( int idcommande) ;
	public void deleteFactureById(int factureId);
	public void mettreAjourTypeFacture(String typefac,int idfacture);
	public Facture getFactureById(int idfacture); 
	public List<Facture> getFactureByClient(int idclient);
	public void updateFacture(Facture f);
	
}
