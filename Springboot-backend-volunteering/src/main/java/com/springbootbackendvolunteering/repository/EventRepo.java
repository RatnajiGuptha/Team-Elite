package com.springbootbackendvolunteering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbackendvolunteering.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer>{

}
