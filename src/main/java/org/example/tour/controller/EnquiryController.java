package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.EnquiryDto;
import org.example.tour.services.enquiryServise.EnquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enquiry")
@RequiredArgsConstructor
public class EnquiryController {
    private final EnquiryService enquiryService;
    @PostMapping("/add")
    public ResponseEntity<?> addEnquiry(@RequestBody EnquiryDto dto){
        try {
            enquiryService.addEnquiry(dto);
            return ResponseEntity.ok("added");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not added");

        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getEnquiry(@RequestParam UUID tourId){
        try {
            return ResponseEntity.ok(enquiryService.getEnquiryByTourId(tourId));

        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getEnquiries(){
        try {
            return ResponseEntity.ok(enquiryService.getEnquirues());

        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllEnquiry(){
        try {
            return ResponseEntity.ok(enquiryService.getAllEnquiry());

        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }
}
