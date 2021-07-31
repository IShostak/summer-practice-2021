package com.ishostak.toursoverplanet.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name="password")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_id")
    private Long passwordId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Size(min = 1, max = 4096)
    @Column(name = "payload", nullable = false, length = 4096)
    private String payload;

    public Password(User user, String payload) {
        this.user = user;
        this.payload = payload;
    }
}
