package com.vamshigvk.hellospringbootjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vamshigvk.hellospringbootjpa.dao.AlienRepo;
import com.vamshigvk.hellospringbootjpa.model.Alien;

//@Controller
@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	// Using MVC and JPA with H2
	
	  //"@RequestMapping("/") public String home() { return "home.jsp"; }  
	  @RequestMapping("/addAlien") public String addAlien(Alien alien) {
	  repo.save(alien); return "home.jsp"; }
	  
	  
	  @RequestMapping("/getAlien") public ModelAndView getAlien(@RequestParam int
	  aid) {
	  ModelAndView mv= new ModelAndView("showAlien.jsp"); Alien alien =
	  repo.findById(aid).orElse(null); mv.addObject(alien); return mv; }
	  
	  @RequestMapping("/getAlienByTech") public ModelAndView getAlien(@RequestParam
	  String tech) {
	  
	  ModelAndView mv= new ModelAndView("showAlien.jsp"); List<Alien> alien =
	  repo.findByTech(tech);
	  
	  System.out.println(repo.findByAidGreaterThan(0));
	  System.out.println(repo.findByListSorted("java"));
	  
	  mv.addObject(alien); return mv; }
	 

	// using REST services in spring boot
	@RequestMapping(path = "/aliens", produces = { "application/xml", "application/json" })
	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	/*
	 * public String getAliens() { return repo.findAll().toString(); }
	 */

	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	/*
	 * public String getAlienById(@PathVariable("aid")int aid) { return
	 * repo.findById(aid).toString(); }
	 */

	// @PostMapping(path="/alien", consumes= {"application/json"})
	@PostMapping(path = "/alien")
	// public Alien addAlien_postman(@RequestBody Alien alien){
	public Alien addAlien_postman(Alien alien) {
		repo.save(alien);
		return alien;
	}

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = repo.getById(aid);
		repo.delete(alien);
		return "alien deleted";
	}

	@PutMapping(path = "/alien")
	public Alien updateOrAddAlien_postman(Alien alien) {
		repo.save(alien);
		return alien;
	}

}
