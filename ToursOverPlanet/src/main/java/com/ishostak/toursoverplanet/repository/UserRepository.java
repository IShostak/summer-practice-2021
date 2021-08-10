package com.ishostak.toursoverplanet.repository;

import com.ishostak.toursoverplanet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by it's email.
     *
     * @param email
     * @return the user with the given email or {@literal Optional#empty()} if none found
     */
    Optional<User> findByEmail(String email);


    /**
     * Retrieves a user by it's email.
     *
     * @param id
     * @return the user with the given id or {@literal Optional#empty()} if none found
     */
    Optional<User> findUserByUserId(long id);

}
