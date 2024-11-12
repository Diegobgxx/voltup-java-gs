package org.voltup.app.repository;

import org.voltup.app.domain.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StrategyRepository extends JpaRepository<Strategy, UUID> {
}
