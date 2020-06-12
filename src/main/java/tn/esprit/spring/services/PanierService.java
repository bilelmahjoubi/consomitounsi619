package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Catalogue;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.repository.ClientRepository;



@Service
public class PanierService  implements IPanierService{
	@Autowired
	PanierRepository  panierRepository; 
	@Autowired
      ClientRepository clientRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductRepository productrepository;
	
	public Panier  Addtocart(Panier panier) {
		
		return panierRepository.save(panier);
	}
	
	
	//ajout des produits au panier 
	//ça marche avec REST
	
	public void   ajouterProduitPanier(int idproduct,int idclient) {
		Product  productManagedEntity = productRepository.findById(idproduct).get();
		Client clientManagedEntity = clientRepository.findById(idclient).get();
         Panier p =new Panier();
		p.setClient(clientManagedEntity);
		List<Product> mesprod= new ArrayList<Product>();
		  mesprod.add(productManagedEntity);
		  p.setProducts(mesprod);
		   panierRepository.save(p);
		
	}	
	public List<Panier> getAllPaniers() {
		return (List<Panier>) panierRepository.findAll();
     }
    public List<String> getClientName(int idclient){
		    return panierRepository.getClientName(idclient);
		
	          }
	
    public List<Product> getProds( int idclient){
    	return panierRepository.getProds(idclient);
    }
    
    
    public float gettotal(int idclient) {
    float	somme=0;
    	ArrayList<Product> prods=(ArrayList<Product>) panierRepository.getProds(idclient);
		 for(int i = 0 ; i < prods.size(); i++) {
			 float p= prods.get(i).getPrice();
			 somme+=p;
			 		 
		 }
		 return somme ;
    	
    }
    
    public float diminuerStockProduit(int idclient) {
    	float newquantity=0;
   ArrayList<Product> prods=(ArrayList<Product>) panierRepository.getProds(idclient);
           for(int i = 0 ; i < prods.size(); i++) {
        	  float  q= prods.get(i).getQuantity();
        	  newquantity=q-1; 
        	  int j =prods.get(i).getIdprod();
     Product productManagedEntity = productrepository.findById(j).get();
     productManagedEntity.setQuantity(newquantity);
     productrepository.save(productManagedEntity);
           }
   return newquantity;
   
    }
    
    public List<Panier> getPaniers( int idclient){
    	return panierRepository.getPaniers(idclient);
    }
    
    @Override
	public void deletePanierById(int idpanier) {
		Panier PanierManagedEntity = panierRepository.findById(idpanier).get();
		panierRepository.delete(PanierManagedEntity);

	}
    

    
}

