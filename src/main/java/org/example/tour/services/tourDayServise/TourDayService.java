package org.example.tour.services.tourDayServise;

import org.apache.coyote.BadRequestException;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.enums.Language;
import org.example.tour.projection.TourDayProjection;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface TourDayService {
    void addTourDay(MultipartFile image, String title, String description, UUID tourId, Language lang) throws BadRequestException;

    List<TourDay> getTourDaysByTourId(UUID tourId, Language lang);

    void editTourDayWithImage(MultipartFile image, String title, String description, UUID tourDayId);
    void editTourDay(String title, String description, UUID tourDayId);

    void deletTourDay(UUID tourDayId);
}
