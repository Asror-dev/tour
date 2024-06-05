package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.EnquiryDto;
import org.example.tour.services.enquiryServise.EnquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enquiry")
@RequiredArgsConstructor
public class EnquiryController {
    private final EnquiryService enquiryService;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/add")
    public ResponseEntity<?> addEnquiry(@RequestBody EnquiryDto dto){
        try {
            enquiryService.addEnquiry(dto);
            return ResponseEntity.ok("added");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not added");

        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get")
    public ResponseEntity<?> getEnquiry(@RequestParam UUID tourId){
        try {
            return ResponseEntity.ok(enquiryService.getEnquiryByTourId(tourId));

        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllEnquiry(){
        try {
            return ResponseEntity.ok(enquiryService.getAllEnquiry());

        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }
}
