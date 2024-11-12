package org.voltup.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_plantation")
@Table(name = "tb_plantation")
@NoArgsConstructor
@AllArgsConstructor
public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate date;
    private String plantType;
    @ManyToOne
    private Strategy strategy;
    @ManyToOne
    private Farm farm;
}
