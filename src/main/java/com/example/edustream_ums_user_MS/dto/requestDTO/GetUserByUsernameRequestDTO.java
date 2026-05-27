package com.example.edustream_ums_user_MS.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NullMarked;

@Getter
@Setter
@AllArgsConstructor
@NullMarked
@Builder
@ToString
public class GetUserByUsernameRequestDTO {

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;
}
