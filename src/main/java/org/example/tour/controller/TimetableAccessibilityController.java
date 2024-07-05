package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.TimetableAccessibilityDto;
import org.example.tour.entity.TimetableAccessibility;
import org.example.tour.entity.enums.Language;
import org.example.tour.services.timetableAccessiblity.TimetableAccessibilityServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/timeTable")
@RequiredArgsConstructor
public class TimetableAccessibilityController {
    private final TimetableAccessibilityServise timetableAccessibilityServise;

    @GetMapping("/get")
    public ResponseEntity<?> getTimetableAccessibilityByTourId(@RequestParam UUID tourId,@RequestHeader("lang") Language lang) {
    try {
            List<TimetableAccessibility> timetableAccessibility = timetableAccessibilityServise.getTimetableAccessibility(tourId,lang);
            return ResponseEntity.ok(timetableAccessibility);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/post")
    public ResponseEntity<?> postTimetableAccessiblity(@RequestBody TimetableAccessibilityDto dto,@RequestHeader("lang") Language lang) {
        try {
            timetableAccessibilityServise.addTimetableAccessibility(dto,lang);
            return ResponseEntity.ok("post timetable accessiblity");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
