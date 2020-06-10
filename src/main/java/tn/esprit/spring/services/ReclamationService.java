package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.ReclamationRepository;
@Service
public class ReclamationService implements IReclamationService{
	
	
	@Autowired
	ReclamationRepository reclamationRepository;
	
	@Override
	public int getNombreRmonth(int m) {
		return reclamationRepository.Rmonth(m);
		}
	
	@Override
	public int getNombreTmonth(int m) {
		return reclamationRepository.Tmonth(m);
		}

}
