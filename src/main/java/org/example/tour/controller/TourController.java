package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.Tour;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.tourServise.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addTour(@RequestParam(required = false) MultipartFile images, @RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description,@RequestParam String description1, @RequestParam Double price, @RequestParam Integer tourDay, @RequestParam String info, @RequestHeader("lang") Language lang) {
        try {
            Tour tour = tourService.addTour(images, video, title, description,description1, price, tourDay, info, lang);
            return ResponseEntity.ok(tour);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllTours(@RequestHeader("lang") Language lang) {
        try {
            return ResponseEntity.ok(tourService.getAllTours(lang));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get/all/admin")
    public ResponseEntity<?> getAllToursAdmin(@RequestHeader("lang") Language lang) {
        try {
            return ResponseEntity.ok(tourService.getAllTours(lang));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getTourById(@RequestParam UUID tourId, @RequestHeader("lang") Language lang) {
        try {
            return ResponseEntity.ok(tourService.getTourById(tourId, lang));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editTour(@RequestParam String title, @RequestParam String description,@RequestParam String description1, @RequestParam Integer tourDay,@RequestParam Double price, @RequestParam UUID id,@RequestParam String info,@RequestParam Language lang) {
        try {
            tourService.editTour(title, description,description1, price, id,tourDay,info,lang);
            return ResponseEntity.ok("Tour edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit/withImage")
    public ResponseEntity<?> editTourWithImage(@RequestParam(required = false) MultipartFile image,@RequestParam String title, @RequestParam String description,@RequestParam String description1, @RequestParam Integer tourDay,@RequestParam Double price, @RequestParam UUID id,@RequestParam String info,@RequestHeader("lang") Language language) {
        try {
            tourService.editTourWithImage(image,title, description, description1, price, id,tourDay,info,language);
            return ResponseEntity.ok("Tour edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit/withVideo")
    public ResponseEntity<?> editTourVideo(@RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description,@RequestParam String description1, @RequestParam Integer tourDay,@RequestParam Double price, @RequestParam UUID id,@RequestParam String info,@RequestHeader("lang") Language language) {
        try {
            tourService.editTourWithVideo(video,title, description,description1, price, id,tourDay,info,language);
            return ResponseEntity.ok("Tour edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit/withVideoAndImage")
    public ResponseEntity<?> editTourWithVideoAndImage(@RequestParam(required = false) MultipartFile image, @RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description,@RequestParam String description1, @RequestParam Integer tourDay,@RequestParam Double price, @RequestParam UUID id,@RequestParam String info,@RequestHeader("lang") Language language) {
        try {
            tourService.editTourVideoAndImage(image,video,title, description,description1, price, id,tourDay,info,language);
            return ResponseEntity.ok("Tour edited successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTour(@RequestParam UUID tourId) {
        try {
            tourService.deletTour(tourId);
            return ResponseEntity.ok("deleted");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("not deleted");

        }
    }
}
