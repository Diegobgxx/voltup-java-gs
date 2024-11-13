package org.voltup.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_connector")
@Table(name = "tb_connector")
@NoArgsConstructor
@AllArgsConstructor
public class ConnectorType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToMany
    private List<Station> stations;
}
