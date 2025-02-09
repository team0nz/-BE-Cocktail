package com.application.common.auth.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SocialLoginDto {
    @NotNull
    private String provider;
    @NotNull
    private String code;
    private String state;
}
