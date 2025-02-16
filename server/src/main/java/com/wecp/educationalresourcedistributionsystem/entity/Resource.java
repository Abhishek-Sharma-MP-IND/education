package com.wecp.educationalresourcedistributionsystem.entity;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "resource_allocation") // do not change table name
public class Resource {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String resourceType;
private String description;

private String availability;

public String getAvailability() {
    return availability;
}

public void setAvailability(String availability) {
    this.availability = availability;
}

@ManyToOne
@JoinColumn(name="event_id")
@JsonIgnore
private Event event;

public Resource(){}




public Resource(Long id, String resourceType, String description, String availability, Event event) {
    this.id = id;
    this.resourceType = resourceType;
    this.description = description;
    this.availability = availability;
    this.event = event;
}

//getter setter
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getResourceType() {
    return resourceType;
}
public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public Event getEvent() {
    return event;
}
public void setEvent(Event event) {
    this.event = event;
}
}

