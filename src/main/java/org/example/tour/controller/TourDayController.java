package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.services.tourDayServise.TourDayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/tourDay")
@RequiredArgsConstructor
public class TourDayController {
    private final TourDayService tourDayService;

    @PostMapping("/add")
    public ResponseEntity<?> addTourDay(@RequestParam(required = false) MultipartFile image, @RequestParam String title,@RequestParam String description, @RequestParam UUID tourId){
        try {
            tourDayService.addTourDay(image, title,description, tourId);
            return ResponseEntity.ok("TourDay added successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getTourDaysByTourId(@RequestParam UUID tourId){
        try {
            return ResponseEntity.ok(tourDayService.getTourDaysByTourId(tourId));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/edit")
    public ResponseEntity<?> editTourDay(@RequestParam(required = false) MultipartFile image, @RequestParam String title,@RequestParam String description, @RequestParam UUID tourDayId){
        try {
            tourDayService.editTourDay(image, title,description, tourDayId);
            return ResponseEntity.ok("TourDay edited successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTourDay(@RequestParam UUID tourDayId){
        try {
            tourDayService.deletTourDay(tourDayId);
            return ResponseEntity.ok("deleted");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not deleted");

        }
    }

}
