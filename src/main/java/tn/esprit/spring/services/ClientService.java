package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.repository.ClientRepository;

@Service

public class ClientService  implements IClientService {
	   @Autowired
	ClientRepository  clientrepository; 
	
	public Client ajouterClient(Client client) {
		return 	 clientrepository.save(client);
			
		}  
	public Client getClientById(int idclient) {
		return clientrepository.findById(idclient).get();	
	}
	public Client getClientByLoginAndPassword(String login, String password) {

		return  clientrepository.getClientByLoginAndPassword(login, password);
		}
	

}
