package com.example.Travellog.Destination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    List<DestinationEntity> findByName(String name);
    List<DestinationEntity> findByDescriptionContaining(String keyword);
    List<DestinationEntity> findByNameAndDescription(String name, String description);
    List<DestinationEntity> findByNameStartingWith(String prefix);

}
