package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.primefaces.model.file.UploadedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.OnRegistrationCompleteEvent;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IUserService;

@Controller(value = "registerController")
@Join(path = "/signup", to = "/signup.jsf")
@Component
public class RegisterController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ApplicationEventPublisher eventPublisher;
	@Autowired
	IUserService userService;
	
	
	private String username;
	private String password;
	private String email;
	private Date dateNaissance;
	private String Adresse;
	private int NumTel;
	private UploadedFiles files;
	
	public String doSignup() {
		String navigateTo = "null";
		if (userRepository.existsByUsername(username)) {
			FacesMessage facesMessage =

					new FacesMessage("Error: Username is already taken!");

					FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
		}

		else if (userRepository.existsByEmail(email)) {
			FacesMessage facesMessage =

					new FacesMessage("Error: Email is already in use!");

					FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
		}
		else
		{
			User user = new User(username, 
					 email,
					 encoder.encode(password),dateNaissance,Adresse,NumTel);
			Set<Role> roles = new HashSet<>();
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			user.setRoles(roles);
			userService.addUserImage(user, files);
			String appUrl = "";
			User registered= user;
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(appUrl, registered));
			navigateTo="login.xhtml?faces-redirect=true";
			FacesMessage facesMessage =

					new FacesMessage("Registered successfully, please verify your account!");

					FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		
	}
	
	public String doSignupmod() {
		String navigateTo = "null";
		if (userRepository.existsByUsername(username)) {
			FacesMessage facesMessage =

					new FacesMessage("Error: Username is already taken!");

					FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
		}

		else if (userRepository.existsByEmail(email)) {
			FacesMessage facesMessage =

					new FacesMessage("Error: Email is already in use!");

					FacesContext.getCurrentInstance().addMessage("form1:btn",facesMessage);
		}
		else
		{
			User user = new User(username, 
					 email,
					 encoder.encode(password),dateNaissance,Adresse,NumTel);
			Set<Role> roles = new HashSet<>();
			Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			user.setRoles(roles);
			userRepository.save(user);
			
			String appUrl = "";
			User registered= user;
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(appUrl, registered));
			navigateTo="login.xhtml?faces-redirect=true";
			FacesMessage facesMessage =

					new FacesMessage("Registered successfully, please verify your account!");

					FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public PasswordEncoder getEncoder() {
		return encoder;
	}
	

	public UploadedFiles getFiles() {
		return files;
	}

	public void setFiles(UploadedFiles files) {
		this.files = files;
	}

	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public int getNumTel() {
		return NumTel;
	}

	public void setNumTel(int numTel) {
		NumTel = numTel;
	}

}