package com.ishostak.toursoverplanet.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {

    private long id;
    private String fullName;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isManager;
}
