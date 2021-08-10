package com.ishostak.toursoverplanet.repository;

import com.ishostak.toursoverplanet.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    /**
     * Retrieves a user by it's email.
     *
     * @param tourName
     * @return the tour with the given email or {@literal Optional#empty()} if none found
     */
    Optional<Tour> findByTourName(String tourName);
}
