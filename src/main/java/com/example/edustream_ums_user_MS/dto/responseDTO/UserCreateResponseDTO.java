package com.example.edustream_ums_user_MS.dto.responseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.jspecify.annotations.NullMarked;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NullMarked
@Builder
@ToString
public class UserCreateResponseDTO {

    private String username;

    private String role;
}
