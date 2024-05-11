package org.example.tour.services.tourDayServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.Image;
import org.example.tour.entity.Tour;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.Video;
import org.example.tour.repository.ImageRepo;
import org.example.tour.repository.TourDayRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourDayServiceImpl implements TourDayService {

    private final TourDayRepo tourDayRepo;
    private final TourRepo tourRepo;
    private final ImageRepo imageRepo;

    @Override
    public void addTourDay(MultipartFile file, String title, UUID tourId) {
        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/images/";
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + uniqueFileName;
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        TourDay tourDay = new TourDay();
        tourDay.setTitle(title);
        tourDay.setTour(tour);
        tourDayRepo.save(tourDay);

        try {
            File uploadFile = new File(filePath);
            file.transferTo(uploadFile);
            Image image =new Image();
            image.setTourDay(tourDay);
            image.setTour(tour);
            image.setName(uniqueFileName);
            image.setPath(filePath);
            imageRepo.save(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, e);
        }
    }
}
