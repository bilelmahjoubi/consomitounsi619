package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.*;
import tn.esprit.spring.entities.*;
@Service

public class ProductService  implements IProductService {

	@Autowired
	ProductRepository productrepository;
	
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productrepository.findAll();
}
	public Product  ajouterProduct(Product product) {
		return 	productrepository.save(product);
			
		}
	 
		 
	 
	 public Product getProductById(int idprod) {
			return productrepository.findById(idprod).get();	
		}
	 
	public List<Product> getProdByCategoryFood(){
		List<Product> foodprod= new ArrayList<Product>();
		ArrayList<Product> prods=(ArrayList<Product>) productrepository.findAll();
		 for(int i = 0 ; i < prods.size(); i++) {
			     
			 if  (prods.get(i).getCategory().toString()=="FOOD")
			 {  int j =prods.get(i).getIdprod();
			 Product productManagedEntity = productrepository.findById(j).get();
			 
				foodprod.add(productManagedEntity);
			
			 }
		 }	 
		
           return foodprod;
	}
	
	public List<Product> getProdByCategoryClothers(){
		List<Product> clothersprod= new ArrayList<Product>();
		ArrayList<Product> prods=(ArrayList<Product>) productrepository.findAll();
		 for(int i = 0 ; i < prods.size(); i++) {
			     
			 if  (prods.get(i).getCategory().toString()=="CLOTHERS")
			 {  int j =prods.get(i).getIdprod();
			 Product productManagedEntity = productrepository.findById(j).get();
			 
			 clothersprod.add(productManagedEntity);
			
			 }
		 }	 
		
           return clothersprod;
	}	
				
	public List<Product> getProdByCategoryJEWLERY(){
		List<Product> JEWLERYprod= new ArrayList<Product>();
		ArrayList<Product> prods=(ArrayList<Product>) productrepository.findAll();
		 for(int i = 0 ; i < prods.size(); i++) {
			     
			 if  (prods.get(i).getCategory().toString()=="JEWLERY")
			 {  int j =prods.get(i).getIdprod();
			 Product productManagedEntity = productrepository.findById(j).get();
			 
			 JEWLERYprod.add(productManagedEntity);
			
			 }
		 }	 
		
           return JEWLERYprod;
	}	
	public List<Product> getProdByCategoryHOMEELEMENTDECORATION(){
		List<Product> HOMEprod= new ArrayList<Product>();
		ArrayList<Product> prods=(ArrayList<Product>) productrepository.findAll();
		 for(int i = 0 ; i < prods.size(); i++) {
			     
			 if  (prods.get(i).getCategory().toString()=="HOMEELEMENTDECORATION")
			 {  int j =prods.get(i).getIdprod();
			 Product productManagedEntity = productrepository.findById(j).get();
			 
			 HOMEprod.add(productManagedEntity);
			
			 }
		 }	 
		
           return HOMEprod;
	
}
	public List<Product> getProdByCategoryARTISANAT(){
		List<Product> ARTISANATprod= new ArrayList<Product>();
		ArrayList<Product> prods=(ArrayList<Product>) productrepository.findAll();
		 for(int i = 0 ; i < prods.size(); i++) {
			     
			 if  (prods.get(i).getCategory().toString()=="ARTISANAT")
			 {  int j =prods.get(i).getIdprod();
			 Product productManagedEntity = productrepository.findById(j).get();
			 
			 ARTISANATprod.add(productManagedEntity);
			
			 }
		 }	 
		
           return ARTISANATprod;
}
}
