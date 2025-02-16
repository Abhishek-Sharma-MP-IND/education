package com.wecp.educationalresourcedistributionsystem.controller;
import com.wecp.educationalresourcedistributionsystem.entity.EventRegistration;
import com.wecp.educationalresourcedistributionsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class StudentController {

    @Autowired RegistrationService registrationService;

    @PostMapping("/api/student/register/{eventId}")
    public ResponseEntity<EventRegistration> registerForEvent(@PathVariable Long eventId, @RequestBody EventRegistration registration) {
        // register in an event and return the registration details with status code 201 (CREATED)

  boolean alreadyRegistered = registrationService.isStudentRegisteredForEvent(eventId, registration.getStudentId());
    
    if (alreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
        EventRegistration registeredEvent = registrationService.registerForEvent(eventId, registration);
        return ResponseEntity.status(201).body(registeredEvent);  // Return status code 201 (CEREATED)


    }

    @GetMapping("/api/student/registration-status/{studentId}")
    public ResponseEntity<List<EventRegistration>> viewRegistrationStatus(@PathVariable Long studentId) {
        // return the list of events registered by the student with status code 200 (OK)
        List<EventRegistration> registrationStatus = registrationService.getRegistrationStatus(studentId);
        return ResponseEntity.ok(registrationStatus);  // Return status code 200 (OK)
    }


    
}


