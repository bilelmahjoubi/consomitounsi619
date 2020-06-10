package tn.esprit.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
@Service
public interface IPanierService {
	
	public void ajouterProduitPanier(int idproduct,int idclient);
	public List<Panier> getAllPaniers();
	public List<String> getClientName(int idclient);
	public List<Product> getProds( int idclient);
	 public float gettotal(int idclient);
	 public float diminuerStockProduit(int idclient);
	 public List<Panier> getPaniers( int idclient);
	 public void deletePanierById(int idpanier);
			 

}
