package org.voltup.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.voltup.app.domain.ConnectorType;
import org.voltup.app.domain.Station;

import java.util.List;
import java.util.UUID;

public interface StationRepository extends JpaRepository<Station, UUID> {
    List<Station> findAllByConnectorTypesContaining(ConnectorType connectorType);
}
