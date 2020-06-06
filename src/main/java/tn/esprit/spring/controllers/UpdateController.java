package tn.esprit.spring.controllers;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserDetailsServiceImpl;




@Controller(value = "updateController")
@Join(path = "/updateprofile", to = "/updateprofile.jsf")
@Component
public class UpdateController {
	
	@Autowired
	UserRepository userRepository;
	private UserDetailsServiceImpl userService;
	private Long id;
	private String username;
	private String email;
	private Date dateNaissance;
	private String adresse;
	private int numTel;
	private User user;
	
	public String updateUser(long id)
	{
		String navigateTo = "null";
		
		
		user = new User();
		System.out.println(id);
		user=userRepository.findById(id).get();
		user.setUsername(UserController.user.getUsername());
		user.setEmail(UserController.user.getEmail());
		user.setDateNaissance(UserController.user.getDateNaissance());
		user.setAdresse(UserController.user.getAdresse());	
		user.setNumTel(UserController.user.getNumTel());
		userRepository.save(user);
		navigateTo="profile.xhtml?faces-redirect=true";
		FacesMessage facesMessage =

				new FacesMessage("updated successfully !");

				FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
				
		return navigateTo;
		
}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDetailsServiceImpl getUserService() {
		return userService;
	}
	public void setUserService(UserDetailsServiceImpl userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		adresse = adresse;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		numTel = numTel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
