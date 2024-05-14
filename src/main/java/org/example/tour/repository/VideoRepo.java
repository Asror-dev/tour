package org.example.tour.repository;

import jakarta.transaction.Transactional;
import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.example.tour.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface VideoRepo extends JpaRepository<Video, UUID> {
    Video getVideoByTour(Tour tour);
@Transactional
@Modifying
    void deleteVideoByTour(Tour tour);
}
