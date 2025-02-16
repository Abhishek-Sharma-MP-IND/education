package com.wecp.educationalresourcedistributionsystem.controller;
import com.wecp.educationalresourcedistributionsystem.entity.EventRegistration;
import com.wecp.educationalresourcedistributionsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class StudentController {


    @PostMapping("/api/student/register/{eventId}")
    public ResponseEntity<EventRegistration> registerForEvent(@PathVariable Long eventId, @RequestBody EventRegistration registration) {
        // register in an event and return the registration details with status code 201 (CREATED)
    }

    @GetMapping("/api/student/registration-status/{studentId}")
    public ResponseEntity<List<EventRegistration>> viewRegistrationStatus(@PathVariable Long studentId) {
        // return the list of events registered by the student with status code 200 (OK)
    }
}
