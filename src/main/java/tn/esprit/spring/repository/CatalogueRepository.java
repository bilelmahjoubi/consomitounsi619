package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Catalogue;

@Repository
public interface CatalogueRepository extends CrudRepository<Catalogue, Integer>{

}
