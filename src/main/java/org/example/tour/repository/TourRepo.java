package org.example.tour.repository;

import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourRepo extends JpaRepository<Tour, UUID> {
}
