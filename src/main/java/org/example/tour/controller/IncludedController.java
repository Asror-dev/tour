package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.IncludedDto;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.includedServise.IncludedServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/included")
@RequiredArgsConstructor
public class IncludedController {
    private final IncludedServise includedServise;
    @PostMapping("/post")
    public ResponseEntity<?> postIncluded(@RequestBody IncludedDto dto, @RequestHeader("lang") Language lang) {
        try {
            includedServise.addIncluded(dto,lang);
            return ResponseEntity.ok("successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteIncluded(@RequestParam UUID includedId){
        try {
            includedServise.deleteIncluded(includedId);
            return ResponseEntity.ok("deleted");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not deleted");

        }
    }
}
