package org.example.tour.repository;

import org.example.tour.entity.TimetableAccessibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TimetableAccessibilityRepo extends JpaRepository<TimetableAccessibility, UUID> {

    @Query(value = "SELECT * FROM timetable_accessibility WHERE tour_id = :tour_id", nativeQuery = true)
    List<TimetableAccessibility> getTimetableAccessibilitiesByTourId(@Param("tour_id") UUID tour_id);

}
