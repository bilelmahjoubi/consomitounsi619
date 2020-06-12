package tn.esprit.spring.services;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
@Service
public interface IClientService {
	public Client ajouterClient(Client client); 
	public Client getClientById(int idclient) ;
	public Client getClientByLoginAndPassword(String login, String password);
	
}
