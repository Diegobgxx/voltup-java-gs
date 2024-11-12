package org.voltup.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StrategyRepository extends JpaRepository<Strategy, UUID> {
}
