package com.vamshigvk.hellospringbootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vamshigvk.hellospringbootjpa.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer>{
//use jpa repository to get data in JSON format
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByListSorted(String tech);
}
