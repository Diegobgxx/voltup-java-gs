package org.voltup.app.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_farm")
@Table(name = "tb_farm")
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private long acre;
    @ManyToOne
    private User user;
}
