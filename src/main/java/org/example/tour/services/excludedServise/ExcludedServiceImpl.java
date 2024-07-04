package org.example.tour.services.excludedServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.ExcludedDto;
import org.example.tour.entity.Excluded;
import org.example.tour.entity.Tour;
import org.example.tour.entity.enums.Language;
import org.example.tour.repository.ExcludeRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcludedServiceImpl implements ExcludedService {
    private final ExcludeRepo excludeRepo;
    private final TourRepo tourRepo;
    @Override
    public void addExcluded(ExcludedDto dto, Language language) {
        Tour tourByIdAndLang = tourRepo.getTourByIdAndLang(dto.getTour_id(), language);
        Excluded excluded=new Excluded();
        excluded.setLang(language);
        excluded.setExcluded(dto.getExcluded());
        excluded.setTour(tourByIdAndLang);
        excludeRepo.save(excluded);
    }
}
