package com.example.edustream_ums_user_MS.service.Impl;

import com.example.edustream_ums_user_MS.dto.requestDTO.UserCreateRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserCreateResponseDTO;
import com.example.edustream_ums_user_MS.entity.User;
import com.example.edustream_ums_user_MS.repository.UserRepository;
import com.example.edustream_ums_user_MS.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {

        log.info("================================ Creating a New User ==============================");

        log.info("Register Request details - Username: {}, Role: {}",
                userCreateRequestDTO.getUsername(),
                userCreateRequestDTO.getRole());

        // Create a new user entity with the requested data
        User createUser = User.builder()
                .username(userCreateRequestDTO.getUsername())
                .password(userCreateRequestDTO.getPassword())
                .role(userCreateRequestDTO.getRole())
                .build();

        // Save the new user to the database
        log.info("Saving new user to database with username: {}", createUser.getUsername());
        userRepository.save(createUser);

        return UserCreateResponseDTO.builder()
                .username(createUser.getUsername())
                .role(createUser.getRole())
                .build();
    }
}
