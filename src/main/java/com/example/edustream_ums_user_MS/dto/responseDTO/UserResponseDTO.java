package com.example.edustream_ums_user_MS.dto.responseDTO;

import lombok.*;
import org.jspecify.annotations.NullMarked;

@Getter
@Setter
@AllArgsConstructor
@NullMarked
@Builder
@ToString
public class UserResponseDTO {

    private String username;

    private String role;
}
