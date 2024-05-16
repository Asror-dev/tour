package org.example.tour.services.tourServise;

import org.example.tour.entity.Tour;
import org.example.tour.entity.enums.Language;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface TourService {
    void addTour(MultipartFile images, MultipartFile video, String title, String description, Double price, Integer tourDay, String info, Language lang) throws IOException;

    List<Tour> getAllTours(Language lang);

    Tour getTourById(UUID tourId,Language lang);

    void editTour(MultipartFile image, MultipartFile video, String title, String description, Double price, UUID tourId,Language lang) throws IOException;

    void deletTour(UUID tourId);
}
