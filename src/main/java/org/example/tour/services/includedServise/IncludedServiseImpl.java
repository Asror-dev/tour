package org.example.tour.services.includedServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.IncludedDto;
import org.example.tour.entity.Included;
import org.example.tour.entity.Tour;
import org.example.tour.entity.enums.Language;
import org.example.tour.repository.IncludedRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncludedServiseImpl implements IncludedServise {
    private final IncludedRepo includedRepo;
    private final TourRepo tourRepo;
    @Override
    public void addIncluded(IncludedDto dto, Language language) {
        Tour tourByIdAndLang = tourRepo.getTourByIdAndLang(dto.getTour_id(), language);
        Included included = new Included();
        included.setIncluded(dto.getIncluded());
        included.setLang(language);
        included.setTour(tourByIdAndLang);
        includedRepo.save(included);
    }

    @Override
    public void deleteIncluded(UUID includedId) {
        Included included = includedRepo.findById(includedId).get();
        included.setTour(null);
        includedRepo.deleteById(includedId);
    }
}
