package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}