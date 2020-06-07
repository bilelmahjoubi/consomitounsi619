package tn.esprit.spring.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.ImageUser;
import tn.esprit.spring.repository.ImageUserRepository;


@Service
public class ImagesUserServiceImpl implements ImageService {

	@Autowired
	ImageUserRepository imagerep;
	
	public ImageUser save(ImageUser image) {
		
		return imagerep.save(image);
	}

	
	


	
	public List<ImageUser> findAllImages(int idUser) {
		return imagerep.findAllImages(idUser);
	}






	@Override
	public ImageUser findImageUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


