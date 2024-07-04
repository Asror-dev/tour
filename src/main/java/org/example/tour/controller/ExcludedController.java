package org.example.tour.controller;

import lombok.RequiredArgsConstructor;

import org.example.tour.dto.ExcludedDto;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.excludedServise.ExcludedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/excluded")
@RequiredArgsConstructor
public class ExcludedController {
    private final ExcludedService excludedService;
    @PostMapping("/post")
    public ResponseEntity<?> postExcluded(@RequestBody ExcludedDto dto,@RequestHeader("lang") Language lang) {
        try {
            excludedService.addExcluded(dto,lang);
            return ResponseEntity.ok("successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestParam UUID excludedId){
        try {
            excludedService.deleteExcluded(excludedId);
            return ResponseEntity.ok("deleted");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not deleted");

        }
    }
}
