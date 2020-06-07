package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ImageUser;

@Repository
public interface ImageUserRepository  extends JpaRepository<ImageUser, Long> {
	@Query(value = "SELECT * FROM image_user  WHERE iduser_id=?1", nativeQuery = true)
	public ImageUser findImageUser(int iduser);
	
	@Query(value = "SELECT * FROM image_user  WHERE iduser_id=?1", nativeQuery = true)
	public List<ImageUser> findAllImages(int iduser);
}
