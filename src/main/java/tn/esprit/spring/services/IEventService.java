package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Event;

public interface IEventService {

	int getNombrePlacesEvent(Long idevent);

	int getNombreParticpEvent(Long idevent);
	
	public List<Long> getEventList();
	
	public Event findOne(long id);

	

}
