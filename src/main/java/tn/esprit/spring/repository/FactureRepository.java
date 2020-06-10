package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;
@Repository
public interface FactureRepository   extends CrudRepository<Facture, Integer>{ 
	@Query("SELECT f    FROM Facture f INNER JOIN f.commande c  INNER JOIN c.client cl  WHERE cl.idclient = :idclient  ")
    public List<Facture> getFactureByClient(@Param("idclient") int idclient);
}
