package com.example.edustream_ums_user_MS.controller;

import com.example.edustream_lib_common.responseDTO.ApiResponse;
import com.example.edustream_ums_user_MS.dto.requestDTO.GetUserByUsernameRequestDTO;
import com.example.edustream_ums_user_MS.dto.requestDTO.UserCreateRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserCreateResponseDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserResponseDTO;
import com.example.edustream_ums_user_MS.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<UserCreateResponseDTO>> createUser(
            @Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO){

        UserCreateResponseDTO responseDTO = userService.createUser(userCreateRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDTO, "User created successfully"));
    }


    @PostMapping("/getByUsername")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getByUsername(
            @Valid @RequestBody GetUserByUsernameRequestDTO requestDTO) {

        UserResponseDTO responseDTO = userService.getByUsername(requestDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(responseDTO, "User retrieved successfully"));
    }
}
