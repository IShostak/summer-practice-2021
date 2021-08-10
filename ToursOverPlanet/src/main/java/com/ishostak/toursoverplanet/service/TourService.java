package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.dto.TourDto;
import com.ishostak.toursoverplanet.entity.Tour;
import com.ishostak.toursoverplanet.exception.TourServiceException;
import com.ishostak.toursoverplanet.repository.TourRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    private final static Logger logger = LoggerFactory.getLogger(TourService.class);

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours() {
        logger.info("Reading all users from db");

        final List<Tour> allTours = tourRepository.findAll();

        return allTours;
    }

    public Tour createTour(Tour tour) throws TourServiceException {
        logger.info("Creating new tour: {}", tour.getTourName());

        if (tourRepository.findByTourName(tour.getTourName()).isPresent()) {
            throw new TourServiceException("Tour already exists" + tour.getTourName());
        }

        Tour tempTour = Tour.builder()
                .tourName(tour.getTourName())
                .tourPrice(tour.getTourPrice())
                .capacity(tour.getCapacity())
                .tourists(new ArrayList<>())
                .build();

        return tourRepository.saveAndFlush(tempTour);
    }

    public void deleteById(long id) {
        tourRepository.deleteById(id);
    }
}
