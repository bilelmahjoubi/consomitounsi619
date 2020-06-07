package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.ImageUser;

public interface ImageService {
	
	public ImageUser save(ImageUser image);

	public List<ImageUser> findAllImages(int idUser);

	public ImageUser findImageUser(int idUser);
}
