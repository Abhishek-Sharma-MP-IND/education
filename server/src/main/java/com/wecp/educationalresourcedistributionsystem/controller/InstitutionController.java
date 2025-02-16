package com.wecp.educationalresourcedistributionsystem.controller;


import com.wecp.educationalresourcedistributionsystem.entity.Event;
import com.wecp.educationalresourcedistributionsystem.entity.Resource;
import com.wecp.educationalresourcedistributionsystem.service.EventService;
import com.wecp.educationalresourcedistributionsystem.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InstitutionController {

    @Autowired
    private ResourceService resourceService;


    @Autowired
    private EventService eventService;


    @PostMapping("/api/institution/event")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
        // create an event and return created event with status code 201 (CREATED)
    }

    @GetMapping("/api/institution/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
        // get all events and return the list with status code 200 (OK)
    }

    @PostMapping("/api/institution/resource")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
        // create a resource and return created resource with status code 201 (CREATED)
    }

    @GetMapping("/api/institution/resources")
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
        // get all resources and return the list with status code 200 (OK)
    }

    // @PostMapping("/api/institution/event/allocate-resources")
    // public ResponseEntity<Event> allocateResource(@RequestParam("eventId") Long eventId,
    //                                                  @RequestParam("resourceId") Long resourceId) {
    //     Event updatedEvent = eventService.allocateResourceToEvent(eventId, resourceId);
    //     return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    //     // allocate a resource to an event and return the updated event with status code 200 (OK)
    // }
    @PostMapping("/api/institution/event/allocate-resources")
    public ResponseEntity<Event> allocateResource(@RequestParam("eventId") Long eventId,
                                                     @RequestParam("resourceId") Long resourceId) {
        Event updatedEvent = eventService.allocateResourceToEvent(eventId, resourceId);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @GetMapping("/api/institution/event/allocated-resources/{eventId}")
    public ResponseEntity<List<Resource>> getAllocatedResources(@PathVariable Long eventId) {
        List<Resource> allocatedResources = resourceService.getAllocatedResources(eventId);
        return new ResponseEntity<>(allocatedResources, HttpStatus.OK);
        // get all resources and return the list with status code 200 (OK)
    }

    @DeleteMapping("/api/institution/event/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

}
