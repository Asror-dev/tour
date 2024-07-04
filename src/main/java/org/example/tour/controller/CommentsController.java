package org.example.tour.controller;
import lombok.RequiredArgsConstructor;
import org.example.tour.dto.CommentDto;
import org.example.tour.entity.Comment;
import org.example.tour.services.commentServise.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    @GetMapping("/get")
    public ResponseEntity<?> getCommentsByTourId(@RequestParam UUID tourId){
        try {
            return ResponseEntity.ok(commentService.getCommentsByTourId(tourId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestParam UUID commentId){
        try {
            commentService.deletComment(commentId);
            return ResponseEntity.ok("deleted");
        }catch (Exception e){
            return ResponseEntity.status(500).body("not deleted");
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody CommentDto dto,@RequestParam UUID tourId){
            commentService.addComment(dto,tourId);
            return ResponseEntity.ok("added");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/change/visible")
    public ResponseEntity<?> changeCommentVisible(@RequestParam UUID commentId){
        try {
            commentService.changeCommentVisible(commentId);
            return ResponseEntity.ok("change");

        }catch (Exception e){
            return ResponseEntity.status(500).body("not change");
        }
    }
    @GetMapping("/visible")
    public ResponseEntity<?> CommentVisible(@RequestParam Boolean visible){
        try {
            List<Comment> commentVisble = commentService.getCommentVisble(visible);
            return ResponseEntity.ok(commentVisble);
        }catch (Exception e){
            return ResponseEntity.status(500).body("not change");
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get/all")
    public ResponseEntity<?> getAllComments(){
        try {
            return ResponseEntity.ok(commentService.getAllComments());
        }catch (Exception e){
            return ResponseEntity.status(500).body("not get");

        }
    }
}
