package org.example.tour.services.includedServise;

import org.example.tour.dto.IncludedDto;
import org.example.tour.entity.enums.Language;

public interface IncludedServise {
    void addIncluded(IncludedDto dto, Language language);
}
