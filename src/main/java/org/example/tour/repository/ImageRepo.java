package org.example.tour.repository;

import jakarta.transaction.Transactional;
import org.example.tour.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageRepo extends JpaRepository<Image, UUID> {
    @Transactional
    @Modifying
    void deleteImageByTour_Id(UUID tourId);

    Image getImageByTourDay(TourDay tourDay);
    @Transactional
    @Modifying
    void deleteImageByTourDayId(UUID tourDayId);
    @Query(value = "SELECT * FROM images WHERE tour_id = :tour_id", nativeQuery = true)
    List<Image> getImagesByTour(@Param("tour_id") UUID tour_id);
}
