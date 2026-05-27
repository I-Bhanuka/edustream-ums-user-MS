package com.example.edustream_ums_user_MS.dto.responseDTO;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.jspecify.annotations.NullMarked;

@Getter
@Setter
@AllArgsConstructor
@NullMarked
@Builder
@ToString
public class UserCreateResponseDTO {

    private String username;

    private String role;
}
