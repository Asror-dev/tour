package org.example.tour.repository;

import org.example.tour.entity.TourDay;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourDayRepo extends JpaRepository<TourDay, UUID> {
}
