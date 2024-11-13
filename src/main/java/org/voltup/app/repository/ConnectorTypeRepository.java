package org.voltup.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voltup.app.domain.ConnectorType;

import java.util.UUID;

public interface ConnectorTypeRepository extends JpaRepository<ConnectorType, UUID> {
}
