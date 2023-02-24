package com.springbootbackendvolunteering.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendvolunteering.model.Event;
import com.springbootbackendvolunteering.repository.EventRepo;
import com.springbootbackendvolunteering.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepo eventRepo;

	// Method to post an event

	public Event planAnEvent(Event event) {

		return eventRepo.save(event);

	}

	// Method to get all the events

	public List<Event> getEvents() {
		return eventRepo.findAll();
	}

}
