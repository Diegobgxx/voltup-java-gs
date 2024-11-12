package org.voltup.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_strategy")
@Table(name = "tb_strategy")
@NoArgsConstructor
@AllArgsConstructor
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String strategyName;
    private String description;
}
