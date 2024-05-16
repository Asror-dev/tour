package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.tourServise.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping("/add")
    public ResponseEntity<?> addTour(@RequestParam(required = false) MultipartFile images, @RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description, @RequestParam Double price, @RequestParam Integer tourDay, @RequestParam String info,

                                      @RequestParam Language lang
                                     ){
    try {
    tourService.addTour(images, video, title, description, price,tourDay,info,lang
    );
    return ResponseEntity.ok("Tour added successfully");
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllTours(@RequestParam Language lang){
        try {
            return ResponseEntity.ok(tourService.getAllTours(lang));

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getTourById(@RequestParam UUID tourId,@RequestParam Language lang){
        try {
            return ResponseEntity.ok(tourService.getTourById(tourId,lang));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/edit")
    public ResponseEntity<?> editTour(@RequestParam(required = false) MultipartFile image,@RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description, @RequestParam Double price,@RequestParam UUID tourId,@RequestParam Language lang){
        try {
            tourService.editTour(image, video, title, description, price,tourId,lang);
            return ResponseEntity.ok("Tour edited successfully");
        }catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTour(@RequestParam UUID tourId){
        try {
            tourService.deletTour(tourId);
            return ResponseEntity.ok("deleted");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not deleted");

        }
    }
}
