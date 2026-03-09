package com.example.packagetracker.repository;

import com.example.packagetracker.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    
    /**
     * Find a package by its unique tracking ID
     * @param trackingId the tracking ID to search for
     * @return Optional containing the package if found
     */
    Optional<Package> findByTrackingId(String trackingId);
    
    /**
     * Check if a package with given tracking ID exists
     * @param trackingId the tracking ID to check
     * @return true if exists, false otherwise
     */
    boolean existsByTrackingId(String trackingId);
}
