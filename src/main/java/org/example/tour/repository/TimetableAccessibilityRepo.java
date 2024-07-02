package org.example.tour.repository;

import org.example.tour.entity.TimetableAccessibility;
import org.example.tour.entity.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TimetableAccessibilityRepo extends JpaRepository<TimetableAccessibility, UUID> {
    List<TimetableAccessibility> getTimetableAccessibilitiesByLangAndTour_Id(Language lang,UUID tour_id);
}
