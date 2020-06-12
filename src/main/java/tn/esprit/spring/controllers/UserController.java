package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserDetailsImpl;
import tn.esprit.spring.services.UserDetailsServiceImpl;

@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/login1.jsf")
public class UserController {
	
private UserDetailsImpl userDetails;

@Autowired
AuthenticationManager authenticationManager;

@Autowired
JwtUtils jwtUtils;

@Autowired
UserRepository userRepository;
@Autowired
RoleRepository roleRepository;
@Autowired
IUserService userService;
@Autowired
UserDetailsServiceImpl userDetailss ;


	
	private String username;
	private String password;
	public static User user;
	private Boolean loggedIn;
	
	
	public String doLogin() {
		
		String navigateTo = "null";
		Authentication authentication = authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		user = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		
		if(user != null && !user.isEnabled()){
			
			FacesMessage facesMessage =
					new FacesMessage("please verify you email .");
					FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);			
		}
		
		else if(user != null && user.getEtatAcc().booleanValue()==false ){
			navigateTo = "/disabled.xhtml?faces-redirect=true";					
		}
		
		else if (user != null && (+user.getRoles().stream().findFirst().get().getId()) ==1) {
		navigateTo = "/home.xhtml?faces-redirect=true";
				loggedIn = true; }
		
		else if (user != null && (+user.getRoles().stream().findFirst().get().getId()) ==2) {
			navigateTo = "/home.xhtml?faces-redirect=true";
			loggedIn = true; }
		else if (user != null && (+user.getRoles().stream().findFirst().get().getId()) ==3) {
			navigateTo = "/welcome.xhtml?faces-redirect=true";
			loggedIn = true; }

		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
	
	public String doLogout()
	{FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login1.xhtml?faces-redirect=true";
	}
	
	
	
		public String DisableUser(String username){
		
			String navigateTo = "null";
		
		User U = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		U.setEtatAcc(false);
		
		userDetailss.updateUser(U);
		
		navigateTo = "/showuser.xhtml?faces-redirect=true";
		
		FacesMessage facesMessage =
				new FacesMessage("User Disabled successfully!");
				FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
				
				return navigateTo;
	}
			
	public List<User> getAllUser() {

		return userService.getAllUser();
	}
	
	


	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}




	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	


}