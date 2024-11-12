package org.voltup.app.repository;

import org.voltup.app.domain.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
    List<Plantation> findAllByFarm(Farm farm);
    List<Plantation> findAllByStrategy(Strategy strategy);

}
