package com.springbootbackendvolunteering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendvolunteering.model.Event;
import com.springbootbackendvolunteering.serviceImplementation.EventServiceImpl;



@RestController
@RequestMapping("/engage")
public class EventController {
	
	
	
	@Autowired
	EventServiceImpl service;
	

	
	// Posting event details by organizer
	
	
	@PostMapping("/events")
	public Event planAnEvent(@RequestBody Event event){
		
		return service.planAnEvent(event);
	}
	
	
	
	
	@GetMapping("/events")
	public List<Event> getEvents(){
		return service.getEvents();
		
	}
	
	
	
}
