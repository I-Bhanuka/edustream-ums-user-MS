package com.example.edustream_ums_user_MS.service.Impl;

import com.example.edustream_ums_user_MS.dto.requestDTO.GetUserByUsernameRequestDTO;
import com.example.edustream_ums_user_MS.dto.requestDTO.UserCreateRequestDTO;
import com.example.edustream_ums_user_MS.dto.requestDTO.ValidateUserRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserCreateResponseDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserResponseDTO;
import com.example.edustream_ums_user_MS.entity.User;
import com.example.edustream_ums_user_MS.exception.UserNotFoundException;
import com.example.edustream_ums_user_MS.repository.UserRepository;
import com.example.edustream_ums_user_MS.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {

        log.info("================================ Creating a New User ==============================");

        log.info("Register Request details - Username: {}, Role: {}",
                userCreateRequestDTO.getUsername(),
                userCreateRequestDTO.getRole());

        // Create a new user entity with the requested data
        User createUser = User.builder()
                .username(userCreateRequestDTO.getUsername())
                .password(passwordEncoder.encode(userCreateRequestDTO.getPassword()))
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


    @Override
    public UserResponseDTO getByUsername(GetUserByUsernameRequestDTO getUserByUsernameRequestDTO) {
        log.info("================================ Retrieving User by Username ==============================");
        String username = getUserByUsernameRequestDTO.getUsername();

        log.info("Retrieving user with username: {}", getUserByUsernameRequestDTO.getUsername());

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));

        return UserResponseDTO.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    @Override
    public UserResponseDTO validateUserCredentials(ValidateUserRequestDTO validateUserRequestDTO) {
        log.info("================================ Validating User Credentials ==============================");
        String username = validateUserRequestDTO.getUsername();
        String password = validateUserRequestDTO.getPassword();

        log.info("Validating credentials for username: {}", username);

        // 1. First it gets the username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));

        // 2. Then it checks whether the given password matches the stored password for that username
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.error("Invalid password for username: {}", username);
            throw new UserNotFoundException("Invalid password for username: " + username);
        }

        return UserResponseDTO.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

}
