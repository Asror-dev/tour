package org.example.tour.services.tourServise;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TourService {
    void addTour(MultipartFile[] images, MultipartFile video, String title, String description, Double price) throws IOException;

}
