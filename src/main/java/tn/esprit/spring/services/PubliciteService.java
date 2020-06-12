package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.PubliciteRepository;


@Service
public class PubliciteService implements IPubliciteService{
	
	@Autowired
	PubliciteRepository publiciteRepository;
	
	@Override
	public List<Object[]> getTopPub(){
		return publiciteRepository.TopPub();
	}

}
