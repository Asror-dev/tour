package org.example.tour.services.timetableAccessiblity;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.TimetableAccessibilityDto;
import org.example.tour.entity.TimetableAccessibility;
import org.example.tour.entity.Tour;
import org.example.tour.entity.enums.Language;
import org.example.tour.repository.TimetableAccessibilityRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimetableAccessibilityServiseImpl implements TimetableAccessibilityServise{
    private final TimetableAccessibilityRepo timetableAccessibilityRepo;
    private final TourRepo tourRepo;
    @Override
    public List<TimetableAccessibility> getTimetableAccessibility(UUID tourId) {
        return timetableAccessibilityRepo.getTimetableAccessibilitiesByTourId(tourId);
    }
    @Override
    public void addTimetableAccessibility(TimetableAccessibilityDto dto, UUID tourId, Language lang) {
        TimetableAccessibility timetableAccessibility = new TimetableAccessibility();
        Tour tour = tourRepo.getTourByIdAndLang(tourId, lang);
        timetableAccessibility.setStartDate(dto.getStartDate());
        timetableAccessibility.setEndDate(dto.getEndDate());
        timetableAccessibility.setTour(tour);
        timetableAccessibilityRepo.save(timetableAccessibility);
    }
}
