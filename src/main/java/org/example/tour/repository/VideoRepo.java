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

public interface VideoRepo extends JpaRepository<Video, UUID> {
    Video getVideoByTour(Tour tour);
@Transactional
@Modifying
    void deleteVideoByTour(Tour tour);
    @Query(value = "SELECT * FROM video WHERE tour_id = :tour_id", nativeQuery = true)
    List<Video> getVideoByTour(@Param("tour_id") UUID tour_id);

}
