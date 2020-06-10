package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Client;

import tn.esprit.spring.services.IClientService;


@RestController
public class RestControllerClient {

 	@Autowired

	IClientService iclientservice;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterClient
	
			@PostMapping("/ajouterClient")
			@ResponseBody
			public Client ajouterClient(@RequestBody Client client)
			{
		     iclientservice.ajouterClient(client);
			return client;
}
}
