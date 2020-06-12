package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Publicite;

@Repository
public interface PubliciteRepository extends JpaRepository<Publicite, Long>{
	
	@Query(value = "SELECT canal,nbr_final_vue FROM publicite ORDER by nbr_final_vue DESC LIMIT 5 ", nativeQuery = true)
	public List<Object[]> TopPub(); 

}
