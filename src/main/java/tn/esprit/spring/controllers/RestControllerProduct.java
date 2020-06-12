package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.IProductService;
@RestController
public class RestControllerProduct {
	@Autowired
	IProductService iproductservice;
	
	
// URL : http://localhost:8081/SpringMVC/servlet/getAllProducts
			@GetMapping(value = "/getAllProducts")
		    @ResponseBody
		    public List<Product> getAllProducts(){
				return iproductservice.getAllProducts();
		    }    
// http://localhost:8081/SpringMVC/servlet/ajouterProduct
			
			@PostMapping("/ajouterProduct")
			@ResponseBody
			public Product ajouterProduct(@RequestBody Product product)
			{
				iproductservice.ajouterProduct(product);
			return product;
			}
			
// URL : http://localhost:8081/SpringMVC/servlet/getProdByCategoryFood
						@GetMapping(value = "/getProdByCategoryFood")
					    @ResponseBody	
					    public List<Product> getProdByCategoryFood() {
						return 	iproductservice.getProdByCategoryFood(); 
						}
// URL : http://localhost:8081/SpringMVC/servlet/getProdByCategoryClothers
						@GetMapping(value = "/getProdByCategoryClothers")
					    @ResponseBody	
					    public List<Product> getProdByCategoryClothers() {
						return 	iproductservice.getProdByCategoryClothers(); 
						}
// URL : http://localhost:8081/SpringMVC/servlet/getProdByCategoryJEWLERY
						@GetMapping(value = "/getProdByCategoryJEWLERY")
					    @ResponseBody	
					    public List<Product> getProdByCategoryJEWLERY() {
						return 	iproductservice.getProdByCategoryJEWLERY();
						}
// URL : http://localhost:8081/SpringMVC/servlet/getProdByCategoryHOMEELEMENTDECORATION
						@GetMapping(value = "/getProdByCategoryHOMEELEMENTDECORATION")
					    @ResponseBody	
					    public List<Product> getProdByCategoryHOMEELEMENTDECORATION() {
						return 	iproductservice.getProdByCategoryHOMEELEMENTDECORATION();
						}	
						
// URL : http://localhost:8081/SpringMVC/servlet/getProdByCategoryARTISANAT
						@GetMapping(value = "/getProdByCategoryARTISANAT")
					    @ResponseBody	
					    public List<Product> getProdByCategoryARTISANAT() {
						return 	iproductservice.getProdByCategoryARTISANAT();
						}				
}
