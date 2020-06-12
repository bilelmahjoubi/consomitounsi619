package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;
@Repository
public interface ClientRepository  extends CrudRepository<Client, Integer>{
	@Query("SELECT c from Client c WHERE c.login = :login AND  c.password = :password")
	public Client getClientByLoginAndPassword(@Param("login")String login, @Param("password")String password);
	}
