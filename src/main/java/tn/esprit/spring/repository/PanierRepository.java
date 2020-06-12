package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;
@Repository
public interface PanierRepository  extends CrudRepository<Panier, Integer>{  
	//SELECT u.name  FROM Client u INNER JOIN u.paniers
	@Query("SELECT u.name,u.lastname,u.telephone,u.adresse,prods.nameprod ,prods.price,SUM(prods.price)   FROM Client u INNER JOIN u.paniers pans INNER JOIN pans.products prods WHERE u.idclient = :idclient  ")
     public List<String> getClientName(@Param("idclient") int idclient);
	
	@Query("SELECT p   FROM Product  p INNER JOIN p.paniers pans INNER JOIN pans.client c WHERE c.idclient = :idclient  ")
    public List<Product> getProds(@Param("idclient") int idclient);
	
	@Query("SELECT pans   FROM Panier  pans INNER JOIN pans.client c  WHERE c.idclient = :idclient  ")
    public List<Panier> getPaniers(@Param("idclient") int idclient);
	
	@Query(value ="INSERT INTO Panier (idcl,idprod) VALUES ( :idcl, :idprod)",nativeQuery = true)
	public void remplirpanier(@Param("idcl")int idcl,@Param("idprod")int idprod);
	
    
}
