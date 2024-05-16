package org.example.tour.services.tourDayServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.*;
import org.example.tour.entity.enums.Language;
import org.example.tour.projection.TourDayProjection;
import org.example.tour.repository.*;
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
    public void addTourDay(MultipartFile file, String title, String description, UUID tourId, Language lang) {
        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/images/";

        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + uniqueFileName;
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        TourDay tourDay = new TourDay();
        tourDay.setTitle(title);
        tourDay.setDescription(description);
        tourDay.setLang(lang);
        tourDayRepo.save(tourDay);

        try {
            File uploadFile = new File(filePath);
            file.transferTo(uploadFile);
            Image image =new Image();
            image.setTourDay(tourDay);
            image.setName(uniqueFileName);
            image.setPath(filePath);
            imageRepo.save(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, e);
        }
    }

    @Override
    public List<TourDayProjection> getTourDaysByTourId(UUID tourId,Language lang) {

        return tourDayRepo.getTourDaysByTourId(tourId,lang);
    }

    @Override
    public void editTourDay(MultipartFile image, String title, String description, UUID tourDayId,Language lang) {
        TourDay tourDay1 = tourDayRepo.findById(tourDayId).orElseThrow();
        tourDay1.setLang(lang);
        tourDay1.setTitle(title);
        tourDay1.setDescription(description);
        TourDay tourDay = tourDayRepo.save(tourDay1);
        Image imageByTourDay = imageRepo.getImageByTourDay(tourDay);
        File file = new File(imageByTourDay.getPath());
        if (file.exists()) {
            file.delete();
            imageByTourDay.setTourDay(null);
            imageRepo.save(imageByTourDay);
            imageRepo.delete(imageByTourDay);
        }
        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/videos/";
        String uniqueFileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
        String filePath = uploadDir + uniqueFileName;
        try {
            File uploadFile = new File(filePath);
            image.transferTo(uploadFile);
            Image image1 =new Image();
            image1.setTourDay(tourDay);
            image1.setName(uniqueFileName);
            image1.setPath(filePath);
            imageRepo.save(image1);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, e);
        }

    }

    @Override
    public void deletTourDay(UUID tourDayId) {
        TourDay tourDay = tourDayRepo.findById(tourDayId).orElseThrow();
        for (Image image : imageRepo.getImagesByTourDay(tourDay.getId())) {
            File file = new File(image.getPath());
            if (file.exists()) {
                file.delete();
            }
            image.setTourDay(null);
            image.setTour(null);
            imageRepo.save(image);
            imageRepo.delete(image);
        }
        tourDayRepo.deleteById(tourDay.getId());
    }
}
