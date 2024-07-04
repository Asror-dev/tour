package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.IncludedDto;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.includedServise.IncludedServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encluded")
@RequiredArgsConstructor
public class EncludedContrller {
    private final IncludedServise includedServise;
    @PostMapping("/post")
    public ResponseEntity<?> postIncluded(@RequestBody IncludedDto dto, @RequestHeader("lang") Language lang) {
        try {
            includedServise.addIncluded(dto,lang);
            return ResponseEntity.ok("Send email successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
