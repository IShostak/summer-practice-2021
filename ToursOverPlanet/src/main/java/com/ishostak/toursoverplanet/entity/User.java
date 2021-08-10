package com.ishostak.toursoverplanet.entity;

import com.ishostak.toursoverplanet.entity.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @ManyToMany
    @Column(name ="user_tours")
    @ToString.Exclude
    private List<Tour> tours;

    @Size(min = 3, max = 256)
    @Column(name = "user_full_name", nullable = false, length = 256)
    private String fullName;

    @Email
    @NotNull
    @Size(min = 10, max = 256)
    @Column(name = "user_email", nullable = false, unique = true, length = 256)
    private String email;

    @ToString.Exclude
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Password password;

    @ElementCollection
    @NotNull
    private Set<Role> roles = new HashSet<>();

    @NotNull
    @Column(name = "is_blocked")
    private boolean isBlocked = false;

    public User(String fullName, String email, Password password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public User(String fullName, String email, Role role) {
        this.fullName = fullName;
        this.email = email;

        roles.add(role);
    }

    public User(String fullName, String email, Set<Role> roles) {
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        if (roles.contains(role)) {
            roles.remove(role);
        }
    }

    public long getUserId() {
        return userId;
    }

}
