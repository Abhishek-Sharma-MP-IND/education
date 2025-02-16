package com.wecp.educationalresourcedistributionsystem.repository;


import com.wecp.educationalresourcedistributionsystem.entity.Resource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {

    @Query("SELECT r FROM Resource r WHERE r.event.id = :eventId")
    List<Resource> getAllocatedResourcesByEventId(@Param("eventId") Long eventId);
    // extend jpa repostiory and add custom method if needed
}
