package com.wecp.educationalresourcedistributionsystem.service;

import com.wecp.educationalresourcedistributionsystem.entity.Event;
import com.wecp.educationalresourcedistributionsystem.entity.Resource;
import com.wecp.educationalresourcedistributionsystem.repository.EventRepository;
import com.wecp.educationalresourcedistributionsystem.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event updateEvent(Long eventId, Event updateEvent){
        Optional<Event> event = eventRepository.findById(eventId);
        if(event != null){
            Event e = event.get();
            updateEvent.setId(e.getId());
            return eventRepository.save(updateEvent);
        }
        else{
            throw new EntityNotFoundException("Event not found");
        }
    }
    public Event allocateResourceToEvent(Long eventId, Long resourceId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));
        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new EntityNotFoundException("Resource not found"));

        resource.setEvent(event);
        resourceRepository.save(resource);

        event.getResourceAllocations().add(resource);
        return eventRepository.save(event);
    }
    
    public void deleteEvent(Long eventId){
            eventRepository.deleteById(eventId);
        }

}