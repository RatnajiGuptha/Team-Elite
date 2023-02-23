package com.springbootbackendvolunteering.service;

import java.util.List;

import com.springbootbackendvolunteering.model.Event;

public interface EventService {

	
	
	public Event planAnEvent(Event event);
	
	public List<Event> getEvents();
}
