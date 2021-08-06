package com.natwest.demo.sea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natwest.demo.sea.persistence.domain.Fish;
import com.natwest.demo.sea.persistence.repo.FishRepo;

@Service
public class FishService {

	public FishRepo repo;

	public FishService(FishRepo repo) {
		super();
		this.repo = repo;
	}
	
	// READ
	public List<Fish> readAll() {
		return this.repo.findAll();
	}

	// FIND
	public Fish findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	public List<Fish> findFishByNameJPQL(String name) {
		return this.repo.findFishByNameJPQL(name);
	}
	public List<Fish> findFishByLengthGreaterThanJPQL(double length) {
		return this.repo.findFishByLengthGreaterThanJPQL(length);
	}
	public List<Fish> findFishByLengthLessThanJPQL(double length) {
		return this.repo.findFishByLengthLessThanJPQL(length);
	}
	
	

	// CREATE
	public Fish createFish(Fish fish) {
		return this.repo.saveAndFlush(fish);
	}
	
	public List<Fish> createListFish(List<Fish> fishes) {
		return this.repo.saveAllAndFlush(fishes);
	}

	// UPDATE
	public Fish updateFish(Long id, Fish fish) {
		Fish exists = this.repo.getById(id);
		exists.setName(fish.getName());
		exists.setColour(fish.getColour());
		exists.setLength(fish.getLength());
		exists.setWeight(fish.getWeight());
		Fish updated = this.repo.save(exists);
		return updated;
	}

	// DELETE
	public Boolean deleteFish(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
