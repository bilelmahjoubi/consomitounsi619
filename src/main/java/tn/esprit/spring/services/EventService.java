package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;

import tn.esprit.spring.repository.EventRepository;


@Service
public class EventService implements IEventService{
	
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public int getNombrePlacesEvent(Long idevent){
		return eventRepository.NombrePlacesEvent(idevent);		
	}
	@Override
	public int getNombreParticpEvent(Long idevent){
		return eventRepository.NombreParticpEvent(idevent);
	}
	public List<Long> getEventList(){
		return eventRepository.EventList();
	}
	
	public Event findOne(long id){
		return eventRepository.findById(id).get();
		}


}
