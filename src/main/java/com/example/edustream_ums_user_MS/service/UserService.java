package com.example.edustream_ums_user_MS.service;

import com.example.edustream_ums_user_MS.dto.requestDTO.UserCreateRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserCreateResponseDTO;

public interface UserService {

    UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);
}
