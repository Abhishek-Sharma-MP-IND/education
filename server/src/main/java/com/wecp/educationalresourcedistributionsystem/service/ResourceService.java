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
public class ResourceService {
    @Autowired 
    private ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }


    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }


    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

 
    public Resource allocateResourceToEvent(Long resourceId, Event event) {
        Optional<Resource> resourceOptional = resourceRepository.findById(resourceId);
        if (resourceOptional.isPresent()) {
            Resource resource = resourceOptional.get();
            resource.setEvent(event);
            return resourceRepository.save(resource);
        } else {
            throw new RuntimeException("Resource not found with ID: " + resourceId);
        }
    }

    public List<Resource> getAllocatedResources(Long id){
        return resourceRepository.getAllocatedResourcesByEventId(id);
    }

    // implement here
}
