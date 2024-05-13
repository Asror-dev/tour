package org.example.tour.services.tourServise;

import org.example.tour.entity.Tour;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TourService {
    void addTour(MultipartFile[] images, MultipartFile video, String title, String description, Double price) throws IOException;

    List<Tour> getAllTours();
}
