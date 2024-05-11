package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.services.tourDayServise.TourDayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/tourDay")
@RequiredArgsConstructor
public class TourDayController {
    private final TourDayService tourDayService;

    @PostMapping("/add")
    public ResponseEntity<?> addTourDay(@RequestParam(required = false) MultipartFile image, @RequestParam String title, @RequestParam UUID tourId){
        try {
            tourDayService.addTourDay(image, title, tourId);
            return ResponseEntity.ok("TourDay added successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
