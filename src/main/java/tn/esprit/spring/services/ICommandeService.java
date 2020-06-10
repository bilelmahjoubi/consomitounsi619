package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Commande;
@Service
public interface ICommandeService {
	public Commande ajouterCommande(Commande commande);
	public void deleteCommandeById(int commandeid);
	public List<Commande> getAllCommandes();
	public Commande getCommandeById(int idcmd);
	//public void mettreAjourTypePaiment(String typepaiment,int idcmd);  
	public int validercommande(int idclient);
	public List<Commande> getCommandeByClient( int idclient);
}
