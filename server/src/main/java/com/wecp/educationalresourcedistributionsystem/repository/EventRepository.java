package com.wecp.educationalresourcedistributionsystem.repository;

import com.wecp.educationalresourcedistributionsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    // extend jpa repostiory and add custom method if needed

    
}
