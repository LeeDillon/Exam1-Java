package com.natwest.demo.sea.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natwest.demo.sea.persistence.domain.Fish;

@Repository
public interface FishRepo extends JpaRepository<Fish, Long> {
	
	@Query("SELECT f from Fish f WHERE f.length > ?1")
	List<Fish> findFishByLengthGreaterThanJPQL(double length);
	
	@Query("SELECT f from Fish f WHERE f.length < ?1")
	List<Fish> findFishByLengthLessThanJPQL(double length);
	
	@Query("SELECT f from Fish f WHERE f.name = ?1")
	List<Fish> findFishByNameJPQL(String name);
	
	

}
