package com.ishostak.toursoverplanet.dto;

import com.ishostak.toursoverplanet.entity.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TourDto {

    @NotNull
    @Size(min = 1, max = 256)
    private String tourName;

    @NotNull
    private long tourPrice;

    @NotNull
    private boolean isHot;

    @NotNull
    private long capacity;
}
