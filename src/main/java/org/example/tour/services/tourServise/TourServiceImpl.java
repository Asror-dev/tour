package org.example.tour.services.tourServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.*;
import org.example.tour.entity.enums.Language;
import org.example.tour.repository.*;
import org.example.tour.entity.Image;
import org.example.tour.entity.Tour;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.Video;
import org.example.tour.repository.ImageRepo;
import org.example.tour.repository.TourDayRepo;
import org.example.tour.repository.TourRepo;
import org.example.tour.repository.VideoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService{
    private final ImageRepo imageRepo;
    private final VideoRepo videoRepo;
    private final TourRepo tourRepo;
    private final CommentRepo commentRepo;
    private final EnquiryRepo enquiryRepo;
    private final  TourDayRepo tourDayRepo;
    @Override
    public void addTour(MultipartFile files, MultipartFile video, String title, String description, Double price, Integer tourDay, String info, Language lang) {
        Tour tour = new Tour();
        tour.setTitle(title);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setTourDay(tourDay);
        tour.setInfo(info);
        tour.setLang(lang);
        Tour saveTour = tourRepo.save(tour);
        createImage(files,saveTour);
        createVideo(video,saveTour);
    }

    @Override
    public List<Tour> getAllTours(Language lang) {
        return tourRepo.getToursByLang(lang);
    }

    @Override
    public Tour getTourById(UUID tourId,Language lang) {
        return tourRepo.getTourByIdAndLang(tourId,lang);
    }

    @Override
    public void editTour(MultipartFile image, MultipartFile video, String title, String description, Double price, UUID tourId,Language lang) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();

        updateVideo(tour, video);
        updateImage(tour, image);
        tour.setTitle(title);
        tour.setDescription(description);
        tour.setPrice(price);
        tour.setLang(lang);
        tourRepo.save(tour);
        createVideo(video,tour);
        createImage(image,tour);
    }

    @Override
    public void deletTour(UUID tourId) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        for (Comment comment : commentRepo.getCommentByTour(tour.getId())) {
            comment.setTour(null);
            commentRepo.save(comment);
            commentRepo.delete(comment);
        }
        for (Enquiry enquiry : enquiryRepo.getEnquiryByTour(tour.getId())) {
            enquiry.setTour(null);
            enquiryRepo.save(enquiry);
            enquiryRepo.delete(enquiry);
        }
        for (Image image : imageRepo.getImagesByTour(tour.getId())) {
            File file = new File(image.getPath());
            if (file.exists()) {
                file.delete();
            }
            image.setTourDay(null);
            image.setTour(null);
            imageRepo.save(image);
            imageRepo.delete(image);
        }
        for (Video video : videoRepo.getVideoByTour(tour.getId())) {
            File file = new File(video.getPath());
            if (file.exists()) {
                file.delete();
            }
            video.setTour(null);
            videoRepo.save(video);
            videoRepo.delete(video);
        }
        for (TourDay tourDay : tourDayRepo.getTourDayByByTour(tour.getId())) {
            tourDay.setTour(null);
            tourDayRepo.save(tourDay);
            tourDayRepo.delete(tourDay);
        }
        tourRepo.deleteById(tourId);

    }

    private void updateImage(Tour tour, MultipartFile files){

        for (Image image : tour.getImages()) {
            File file = new File(image.getPath());
            if (file.exists()) {
                file.delete();
                image.setTour(null);
                imageRepo.save(image);
                imageRepo.delete(image);
            }
        }
        tour.setImages(null);
        tourRepo.save(tour);
    }

    private void updateVideo(Tour tour, MultipartFile video) {
        Video videoByTour = videoRepo.getVideoByTour(tour);
        File file = new File(videoByTour.getPath());
        if (file.exists()) {
            file.delete();
        }
        videoByTour.setTour(null);
        videoRepo.save(videoByTour);
        videoRepo.delete(videoByTour);
        tour.setVideos(null);
        tourRepo.save(tour);


    }

    private void createImage(MultipartFile files, Tour tour)  {

        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/images/";

            String uniqueFileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
            String filePath = uploadDir + uniqueFileName;
            try {
                File uploadFile = new File(filePath);
                files.transferTo(uploadFile);
                Image image = new Image();
                image.setName(uniqueFileName);
                image.setPath(filePath);
                image.setTour(tour);
                imageRepo.save(image);


            } catch (IOException e) {
                throw new RuntimeException("Failed to store file " + uniqueFileName, e);
            }

    }
    private void createVideo(MultipartFile file, Tour tour) {

        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/videos/";
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + uniqueFileName;
        try {
            File uploadFile = new File(filePath);
            file.transferTo(uploadFile);
            Video video = new Video();
            video.setName(uniqueFileName);
            video.setPath(filePath);
            video.setTour(tour);
            videoRepo.save(video);


        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, e);
        }
    }

}
