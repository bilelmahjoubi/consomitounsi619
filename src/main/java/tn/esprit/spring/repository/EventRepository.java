package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
	
	@Query(value = "SELECT e.nbplace FROM event as e WHERE e.id_e=?1", nativeQuery = true)
	public int NombrePlacesEvent(Long idevent);
	@Query(value = "SELECT e.nbparticipant FROM event as e WHERE e.id_e=?1", nativeQuery = true)
	public int NombreParticpEvent(Long idevent);
	@Query(value = "SELECT DISTINCT e.id_e FROM event as e", nativeQuery = true)
	public List<Long> EventList();
	
}
