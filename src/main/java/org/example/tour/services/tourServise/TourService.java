package org.example.tour.services.tourServise;

import org.example.tour.entity.Tour;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface TourService {
    void addTour(MultipartFile images, MultipartFile video, String title, String description, Double price,Integer tourDay,String info,MultipartFile tourDayImage,String tourDayTitle, String tourDayDescription) throws IOException;

    List<Tour> getAllTours();

    Tour getTourById(UUID tourId);

    void editTour(MultipartFile image, MultipartFile video, String title, String description, Double price, UUID tourId) throws IOException;

    void deletTour(UUID tourId);
}
