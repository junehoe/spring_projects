package com.junehoe.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.junehoe.dojosninjas.models.Ninja;
import com.junehoe.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}

}
