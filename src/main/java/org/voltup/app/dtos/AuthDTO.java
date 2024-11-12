package org.voltup.app.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthDTO(@NotBlank String email, @NotBlank String senha) {
}