package org.example.tour.services.tourServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.Image;
import org.example.tour.entity.Tour;
import org.example.tour.entity.Video;
import org.example.tour.repository.ImageRepo;
import org.example.tour.repository.TourRepo;
import org.example.tour.repository.VideoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService{
    private final ImageRepo imageRepo;
    private final VideoRepo videoRepo;
    private final TourRepo tourRepo;
    @Override
    public void addTour(MultipartFile[] files, MultipartFile video, String title, String description, Double price) throws IOException {
        Tour tour = new Tour();
//        List<Video> videos = new ArrayList<>();
//        createImage(files,images);
//        List<Video> video1 = createVideo(video);
        tour.setTitle(title);
        tour.setDescription(description);
        tour.setPrice(price);
//        tour.setImages(images);
//        tour.setVideos(video1);
        Tour saveTour = tourRepo.save(tour);
        createImage(files,saveTour);
        createVideo(video,saveTour);
    }

    private void createImage(MultipartFile[] files, Tour tour) throws IOException {

        String uploadDir = "G:/Tour/tour/src/main/java/org/example/tour/uploads/images/";
        for (MultipartFile file : files) {
            String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = uploadDir + uniqueFileName;
            try {
                File uploadFile = new File(filePath);
                file.transferTo(uploadFile);

                Image image = new Image();
                image.setName(uniqueFileName);
                image.setPath(filePath);
                image.setTour(tour);
                imageRepo.save(image);


            } catch (IOException e) {
                throw new RuntimeException("Failed to store file " + uniqueFileName, e);
            }
        }
    }
    private List<Video> createVideo(MultipartFile file,Tour tour) throws IOException {

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
            Video save = videoRepo.save(video);

            return List.of(save);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, e);
        }
    }

}
