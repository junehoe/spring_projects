package com.junehoe.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junehoe.dojosninjas.models.Dojo;
import com.junehoe.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public Dojo findDojoById(Long id) {
		return dojoRepository.findOne(id);
	}
	
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}

}
