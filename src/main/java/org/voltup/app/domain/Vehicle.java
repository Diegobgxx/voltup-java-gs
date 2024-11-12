package org.voltup.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_vehicle")
@Table(name = "tb_vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String model;
    private String brand;
    private double kmRange;
    @ManyToOne
    private ConnectorType connectorType;
    @ManyToOne
    private User user;
}
