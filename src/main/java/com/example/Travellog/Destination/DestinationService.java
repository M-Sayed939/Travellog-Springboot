package com.example.Travellog.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public DestinationEntity addDestination(DestinationEntity destination) {
        return destinationRepository.save(destination);
    }

    public List<DestinationEntity> getAllDestinations() {
        return destinationRepository.findAll();
    }
//    public void saveDestination(DestinationEntity destination) {
//        destinationRepository.save(destination);
//    }
    public DestinationEntity getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
