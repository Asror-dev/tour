package org.example.tour.repository;

import jakarta.transaction.Transactional;
import org.example.tour.entity.Image;
import org.example.tour.entity.Tour;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface ImageRepo extends JpaRepository<Image, UUID> {
    @Transactional
    @Modifying
    void deleteImageByTour_Id(UUID tourId);

    Image getImageByTourDay(TourDay tourDay);
    @Transactional
    @Modifying
    void deleteImageByTourDayId(UUID tourDayId);
}
