package org.example.tour.services.tourDayServise;

import org.example.tour.projection.TourDayProjection;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface TourDayService {
    void addTourDay(MultipartFile image, String title, String description, UUID tourId);

    List<TourDayProjection> getTourDaysByTourId(UUID tourId);

    void editTourDay(MultipartFile image, String title, String description, UUID tourDayId);

    void deletTourDay(UUID tourDayId);
}
