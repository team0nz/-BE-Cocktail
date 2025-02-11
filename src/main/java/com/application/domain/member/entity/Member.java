package com.application.domain.member.entity;

import com.application.common.time.BaseTimeEntity;
import com.application.domain.member.enums.Gender;
import com.application.domain.member.enums.Role;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name="member")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="credential_id", nullable = false, unique = true)
    private String creadentialId;
    @Column(name="name")
    private String name;
    @Column(name="nickname")
    private String nickname;
    @Column(name="email")
    private String email;
    @Column(name="gender")
    private Gender gender;
    @Column(name="addr")
    private String addr;
    @Column(name="age")
    private Integer age;
    @Column(name="profile")
    private String profile;
    @Column(name="role", nullable = false)
    private Role role;// Admin, User, Other


    @Builder
    public Member(String name, String email, String profile, Role role){
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.role = role;
    }

    public Member update(String name, String profile){
        this.name = name;
        this.profile = profile;
        return this;
    }

    public String getRole(){
        return this.role.getEnglish();
    }


}
