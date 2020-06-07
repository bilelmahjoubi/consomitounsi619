package tn.esprit.spring.controllers;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.ImageUser;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.ImageService;

@Controller(value = "ImageUserController")
@Component
public class ImageUserController {
	@Autowired
	ImageService imgser;
	
	
	private Long id;
	private String image;
	private User user;
	
	
	public ImageService getImgser() {
		return imgser;
	}

	public void setImgser(ImageService imgser) {
		this.imgser = imgser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ImageUser> findAllImages(int idUser) {
		return imgser.findAllImages(idUser);
	}
	
	public ImageUser getImageUser(int idUser){
		ImageUser img=imgser.findAllImages(idUser).get(0);
		return img;
	}
	
	
}