package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.services.tourServise.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping("/add")
    public ResponseEntity<?> addTour( @RequestParam(required = false) MultipartFile[] images,@RequestParam(required = false) MultipartFile video, @RequestParam String title, @RequestParam String description, @RequestParam Double price){
try {
    tourService.addTour(images, video, title, description, price);
    return ResponseEntity.ok("Tour added successfully");
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
