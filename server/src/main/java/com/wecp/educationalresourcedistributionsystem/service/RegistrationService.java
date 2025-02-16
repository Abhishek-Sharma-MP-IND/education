package com.wecp.educationalresourcedistributionsystem.service;

import com.wecp.educationalresourcedistributionsystem.entity.Event;
import com.wecp.educationalresourcedistributionsystem.entity.EventRegistration;
import com.wecp.educationalresourcedistributionsystem.repository.EventRepository;
import com.wecp.educationalresourcedistributionsystem.repository.EventRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired 
    private EventRepository eventRepository;

    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    public EventRegistration registerForEvent(Long eventId, EventRegistration registration) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with ID: " + eventId));
        registration.setEvent(event);
        return eventRegistrationRepository.save(registration);
    }

    public List<EventRegistration> getRegistrationStatus(Long studentId) {
        return eventRegistrationRepository.findByStudentId(studentId);
    }

    public boolean isStudentRegisteredForEvent(Long eventId, Long studentId) {
        return eventRegistrationRepository.existsByEventIdAndStudentId(eventId, studentId);
    }

    // public List<Even
}