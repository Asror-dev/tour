package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.tourDayServise.TourDayService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/tourDay")
@RequiredArgsConstructor
public class TourDayController {
    private final TourDayService tourDayService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addTourDay(@RequestParam(required = false) MultipartFile image, @RequestParam String title, @RequestParam String description, @RequestParam UUID tourId, @RequestHeader("lang") Language lang){
        try {
            tourDayService.addTourDay(image, title,description, tourId,lang);
            return ResponseEntity.ok("TourDay added successfully");
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException ignored){
            return ResponseEntity.internalServerError().body("Image have not been saved successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getTourDaysByTourId(@RequestParam UUID tourId,@RequestHeader("lang") Language lang){
        try {
            return ResponseEntity.ok(tourDayService.getTourDaysByTourId(tourId,lang));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public ResponseEntity<?> editTourDay(@RequestParam String title,@RequestParam String description, @RequestParam UUID id){
        try {
            tourDayService.editTourDay(title,description, id);
            return ResponseEntity.ok("TourDay edited successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/edit/withImage")
    public ResponseEntity<?> editTourDayWithImage(@RequestParam(required = false) MultipartFile image, @RequestParam String title,@RequestParam String description, @RequestParam UUID id){
        try {
            tourDayService.editTourDayWithImage(image, title,description, id);
            return ResponseEntity.ok("TourDay edited successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
