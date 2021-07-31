package com.ishostak.toursoverplanet.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @ManyToMany
    @Column(name ="user_tours")
    private List<Tour> tours;

    @Size(min = 3, max = 256)
    @Column(name = "user_full_name", nullable = false, length = 256)
    private String fullName;

    @Email
    @NotNull
    @Size(min = 10, max = 256)
    @Column(name = "user_email", nullable = false, unique = true, length = 256)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Password password;

    public User(String fullName, String email, Password password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
