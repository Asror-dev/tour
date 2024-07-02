package org.example.tour.services.timetableAccessiblity;

import org.example.tour.dto.TimetableAccessibilityDto;
import org.example.tour.entity.TimetableAccessibility;
import org.example.tour.entity.enums.Language;

import java.util.List;
import java.util.UUID;

public interface TimetableAccessibilityServise {
    List<TimetableAccessibility> getTimetableAccessibility(UUID tourId,Language lang);
    void addTimetableAccessibility(TimetableAccessibilityDto dto, UUID tourId, Language language);
}
