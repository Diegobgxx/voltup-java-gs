package org.voltup.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voltup.app.domain.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findAllByUserId(UUID userId);
}
