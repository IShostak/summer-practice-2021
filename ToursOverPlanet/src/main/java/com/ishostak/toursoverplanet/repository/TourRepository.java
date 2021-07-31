package com.ishostak.toursoverplanet.repository;

import com.ishostak.toursoverplanet.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {

}
