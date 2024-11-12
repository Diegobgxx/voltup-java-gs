package org.voltup.app.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.voltup.app.domain.Type;

public record UserDTO(
        @Size(min = 1, max = 255)
        @NotBlank
        String firstName,
        @Size(min = 1, max = 255)
        @NotBlank
        String lastName,
        @Email
        String email,
        @Enumerated(EnumType.STRING)
        Type type,
        @NotBlank
        String password
) {}
