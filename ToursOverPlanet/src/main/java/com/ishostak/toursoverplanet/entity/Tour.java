package com.ishostak.toursoverplanet.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Tour {

    @Id
    @Column(name = "tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tourId;

    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "tour_name", unique = true, nullable = false, length = 256)
    private String tourName;

    @NotNull
    @Column(name = "tour_price")
    private long tourPrice;

    @NotNull
    private boolean isHot;

    @NotNull
    private boolean isFull;

    @NotNull
    private long capacity;

    @NotNull
    @ManyToMany
    private List<User> tourists;
}
