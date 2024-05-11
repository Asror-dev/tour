package org.example.tour.services.tourDayServise;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface TourDayService {
    void addTourDay(MultipartFile image, String title, UUID tourId);
}
