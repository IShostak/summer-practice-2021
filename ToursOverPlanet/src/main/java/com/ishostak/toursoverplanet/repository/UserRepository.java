package com.ishostak.toursoverplanet.repository;

import com.ishostak.toursoverplanet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by it's email.
     *
     * @param email
     * @return the user with the given email or {@literal Optional#empty()} if none found
     */
    Optional<User> findByEmail(String email);
}
