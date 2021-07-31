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
public class RegistrationDto {

    @NotNull
    @NotEmpty
    @Size(max = 64)
    private String fullName;

    @NotNull
    @NotEmpty
    @Size(max = 256)
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 32)
    @ValidPassword
    private String password;

}
