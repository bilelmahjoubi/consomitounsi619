package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;

@Service
public interface IProductService {
	public List<Product> getAllProducts();
	public Product ajouterProduct(Product product);
	public Product getProductById(int idprod); 
	public List<Product> getProdByCategoryFood();
	public List<Product> getProdByCategoryClothers();
	public List<Product> getProdByCategoryJEWLERY();
	public List<Product> getProdByCategoryHOMEELEMENTDECORATION();
	public List<Product> getProdByCategoryARTISANAT();
	
}
