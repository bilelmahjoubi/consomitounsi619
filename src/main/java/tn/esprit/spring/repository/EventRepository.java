package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	
	@Query("SELECT nbparticipant FROM Event WHERE id= ?1")
    public int nbpart(int n);
	@Query("SELECT nbplace FROM Event WHERE id= ?1")
    public int nbplace(int n);
	@Query("Select titre from Event where id= ?1")
	public String titre(int n);
	

	

}
