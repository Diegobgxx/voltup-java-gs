package org.voltup.app.service;

import org.voltup.app.domain.User;
import org.voltup.app.dtos.UserDTO;
import org.voltup.app.infra.exceptions.UserAlreadyExistsException;
import org.voltup.app.infra.exceptions.UserNotFoundException;
import org.voltup.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(UserDTO dto) {

        boolean userExists = repository.findByEmail(dto.email()).isPresent();
        if (userExists) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(encryptedPassword)
                .type(dto.type())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .deletedAt(null)
                .build();

        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }


}
