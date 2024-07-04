package org.example.tour.services.excludedServise;

import org.example.tour.dto.ExcludedDto;
import org.example.tour.entity.enums.Language;

public interface ExcludedService {
    void addExcluded(ExcludedDto dto, Language language);
}
