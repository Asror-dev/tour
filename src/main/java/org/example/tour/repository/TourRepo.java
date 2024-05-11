package org.example.tour.repository;

import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TourRepo extends JpaRepository<Tour, UUID> {
}
