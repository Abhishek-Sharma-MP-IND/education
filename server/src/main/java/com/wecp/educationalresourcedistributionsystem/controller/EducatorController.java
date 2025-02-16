package com.wecp.educationalresourcedistributionsystem.controller;

import com.wecp.educationalresourcedistributionsystem.entity.Event;
import com.wecp.educationalresourcedistributionsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducatorController {
    

    @Autowired
    private EventService eventService;

    @GetMapping("/api/educator/agenda")
    public ResponseEntity<List<Event>> viewEventsAgenda() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
        // gll all events and return with status code 200 OK
    }

    @PutMapping("/api/educator/update-material/{eventId}")
    public ResponseEntity<Event> updateEventMaterial(@PathVariable Long eventId , @RequestBody Event updateEvent) {
        return new ResponseEntity<>(eventService.updateEvent(eventId, updateEvent), HttpStatus.OK);
        // update the event and return with status code 200 OK
    }
}
