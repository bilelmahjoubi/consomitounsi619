package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;
@Repository
public interface CommandeRepository  extends CrudRepository<Commande, Integer>{ 
	@Query("SELECT c    FROM Commande c INNER JOIN c.client cl WHERE cl.idclient = :idclient  ")
    public List<Commande> getCommandeByClient(@Param("idclient") int idclient);
}
