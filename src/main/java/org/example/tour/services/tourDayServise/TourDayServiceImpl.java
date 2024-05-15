package org.example.tour.services.tourDayServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.*;
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
    private final CommentRepo commentRepo;
    private final EnquiryRepo enquiryRepo;
    private final VideoRepo videoRepo;
    @Override
    public void addTourDay(MultipartFile file, String title, String description, UUID tourId) {
        String uploadDir = "D:/Spring/tour/src/main/java/org/example/tour/uploads/images";

        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + uniqueFileName;
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        TourDay tourDay = new TourDay();
        tourDay.setTitle(title);
        tourDay.setDescription(description);
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

    @Override
    public List<TourDayProjection> getTourDaysByTourId(UUID tourId) {

        return tourDayRepo.getTourDaysByTourId(tourId);
    }

    @Override
    public void editTourDay(MultipartFile image, String title, String description, UUID tourDayId) {
        TourDay tourDay = tourDayRepo.findById(tourDayId).orElseThrow();
        Image imageByTourDay = imageRepo.getImageByTourDay(tourDay);
        File file = new File(imageByTourDay.getPath());
        if (file.exists()) {
            file.delete();
            imageByTourDay.setTourDay(null);
            imageRepo.save(imageByTourDay);
            imageRepo.delete(imageByTourDay);
        }
        String uploadDir = "D:/Spring/tour/src/main/java/org/example/tour/uploads/videos/";
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
//        for (Comment comment : commentRepo.getCommentByTour(tourDay.getTour().getId())) {
//            comment.setTour(null);
//            commentRepo.save(comment);
//            commentRepo.delete(comment);
//        }
//        for (Enquiry enquiry : enquiryRepo.getEnquiryByTour(tourDay.getTour().getId())) {
//            enquiry.setTour(null);
//            enquiryRepo.save(enquiry);
//            enquiryRepo.delete(enquiry);
//        }
//        for (Image image : imageRepo.getImagesByTour(tourDay.getTour().getId())) {
//            File file = new File(image.getPath());
//            if (file.exists()) {
//                file.delete();
//            }
//            image.setTourDay(null);
//            imageRepo.save(image);
//            imageRepo.delete(image);
//        }
//        for (Video video : videoRepo.getVideoByTour(tourDay.getTour().getId())) {
//            File file = new File(video.getPath());
//            if (file.exists()) {
//                file.delete();
//            }
//            video.setTour(null);
//            videoRepo.save(video);
//            videoRepo.delete(video);
//        }
        tourDayRepo.deleteById(tourDayId);
    }
}
