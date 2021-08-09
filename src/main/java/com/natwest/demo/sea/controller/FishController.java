package com.natwest.demo.sea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.demo.sea.persistence.domain.Fish;
import com.natwest.demo.sea.service.FishService;

@RestController
@CrossOrigin
public class FishController {

	@Autowired
	private FishService service;

	public FishController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Fish>> getAll() {
		return new ResponseEntity<List<Fish>>(this.service.readAll(), HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Fish> createFish(@RequestBody Fish fish) {
		return new ResponseEntity<Fish>(this.service.createFish(fish), HttpStatus.CREATED);
	}
	@PostMapping("/createList")
	public ResponseEntity<List<Fish>> createListFish(@RequestBody List<Fish> fishes) {
		return new ResponseEntity<List<Fish>>(this.service.createListFish(fishes), HttpStatus.CREATED);
	}
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Fish> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Fish>(this.service.findById(id), HttpStatus.FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Fish> updateFish(@PathVariable("id") Long id, @RequestBody Fish fish) {
		return new ResponseEntity<Fish>(this.service.updateFish(id, fish), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteFish(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteFish(id), HttpStatus.NO_CONTENT);
	}
	@GetMapping("/findFishByNameJPQL/{name}")
	public ResponseEntity<List<Fish>> findFishByNameJPQL(@PathVariable("name") String name) {
		return new ResponseEntity<List<Fish>>(this.service.findFishByNameJPQL(name), HttpStatus.FOUND);
	}
	@GetMapping("/findFishByLengthGreaterThanSQL/{length}")
	public ResponseEntity<List<Fish>> findFishByLengthGreaterThanJPQL(@PathVariable("length") double length) {
		return new ResponseEntity<List<Fish>>(this.service.findFishByLengthGreaterThanJPQL(length), HttpStatus.FOUND);
	}
	@GetMapping("/findFishByLengthLessThanJPQL/{length}")
	public ResponseEntity<List<Fish>> findFishByLengthLessThanJPQL(@PathVariable("length") double length) {
		return new ResponseEntity<List<Fish>>(this.service.findFishByLengthLessThanJPQL(length), HttpStatus.FOUND);
	}
}
