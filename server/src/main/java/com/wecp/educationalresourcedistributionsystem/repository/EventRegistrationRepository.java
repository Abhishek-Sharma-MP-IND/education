package com.wecp.educationalresourcedistributionsystem.repository;


import com.wecp.educationalresourcedistributionsystem.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRegistrationRepository extends JpaRepository <EventRegistration, Long>{
    // extend jpa repostiory and add custom method if needed
    List<EventRegistration> findByStudentId(Long studentId);

    boolean existsByEventIdAndStudentId(Long eventId, Long studentId);

    
}
