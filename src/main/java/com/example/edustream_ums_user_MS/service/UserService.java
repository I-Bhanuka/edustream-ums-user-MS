package com.example.edustream_ums_user_MS.service;

import com.example.edustream_ums_user_MS.dto.requestDTO.GetUserByUsernameRequestDTO;
import com.example.edustream_ums_user_MS.dto.requestDTO.UserCreateRequestDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserCreateResponseDTO;
import com.example.edustream_ums_user_MS.dto.responseDTO.UserResponseDTO;

public interface UserService {

    UserCreateResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);

    UserResponseDTO getByUsername(GetUserByUsernameRequestDTO getUserByUsernameRequestDTO);
}
