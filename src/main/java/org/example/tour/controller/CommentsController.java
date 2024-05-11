package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.services.commentServise.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    @GetMapping("/get")
    public ResponseEntity<?> getCommentsByTourId(@RequestParam UUID tourId){
         return ResponseEntity.ok(commentService.getCommentsByTourId(tourId));
    }
}
