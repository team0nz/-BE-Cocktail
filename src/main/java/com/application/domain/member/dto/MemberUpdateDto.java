package com.application.domain.member.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberUpdateDto {

    @NotNull
    @Pattern(regexp = "^(?i)(male|femaile)$", message="Invalid gender. Must be 'male' or 'female'")
    private String gender;
    @NotNull
    private String nickName;
    private String name;
    private String addr;
    private Integer age;
    private String profile;

}
