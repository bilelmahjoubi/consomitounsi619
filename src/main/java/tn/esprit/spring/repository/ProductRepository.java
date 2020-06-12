package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Category;
import tn.esprit.spring.entities.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	//@Query("select p from product p where p.category=:category")
     //List<Product> findByCategory(@Param("category") String category);
}

	


