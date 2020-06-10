package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.EventRepository;

@Service
public class EventService implements IEventService{
	
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public int getNbpart(int n) {
		return eventRepository.nbpart(n);
		}
	
	@Override
	public int getNbplace(int n) {
		return eventRepository.nbplace(n);
		}
	
	

}
