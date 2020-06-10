package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long>{
	
	
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(dateT)= ?1")
    public int Tmonth(int m);
	@Query("SELECT COUNT(*) FROM Reclamation WHERE Month(date_rec)= ?1")
    public int Rmonth(int m);

}
