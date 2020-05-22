package tn.esprit.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.services.UserDetailsImpl;
import tn.esprit.spring.services.UserDetailsServiceImpl;

@Scope(value = "session")
@Controller(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/login1.jsf")
public class UserController {
	
@Autowired
UserDetailsServiceImpl userDetails;

@Autowired
AuthenticationManager authenticationManager;

@Autowired
JwtUtils jwtUtils;

@Autowired
UserRepository userRepository;
	
	private String username;
	private String password;
	private User user;
	private Boolean loggedIn;
	
	
	public String doLogin() {
		
		String navigateTo = "null";
		Authentication authentication = authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		User user = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
		if (user != null) {
		navigateTo = "/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
	
	
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login1.xhtml?faces-redirect=true";
		}
		
		
		
	
	public UserDetailsServiceImpl getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsServiceImpl userDetails) {
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