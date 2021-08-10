package com.ishostak.toursoverplanet.dto;

import com.ishostak.toursoverplanet.dto.Utils.ValidEmail;
import com.ishostak.toursoverplanet.dto.Utils.ValidPassword;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class UserUpdateDto {

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String fullName;

    @NotNull
    @NotEmpty
    @Size(max = 256)
    @ValidEmail
    private String email;

    private boolean isManager;

    private boolean isAdmin;

    private boolean isBlocked;

    private long id;

}
