package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class ImageUser implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Image;
	
	@JsonIgnore
	@ManyToOne
	private User Iduser;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public User getIduser() {
		return Iduser;
	}

	public void setIduser(User iduser) {
		Iduser = iduser;
	}

	public ImageUser() {
		super();
	
	}

	public ImageUser(Long id, String image, User iduser) {
		super();
		Id = id;
		Image = image;
		Iduser = iduser;
	}

	public ImageUser(String image) {
		super();
		Image = image;
	}
	
	
	
	

}
