package com.example.Travellog.Destination;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<DestinationEntity>> listDestinations() {
        List<DestinationEntity> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);

    }
    @PostMapping
    public ResponseEntity<DestinationEntity> saveDestination(@RequestBody DestinationEntity newDestination) {
        DestinationEntity destination = destinationService.addDestination(newDestination);
        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        DestinationEntity existingDestination = destinationService.getDestinationById(id);
        if (existingDestination != null) {
            destinationService.deleteDestination(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
