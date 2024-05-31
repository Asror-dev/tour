package org.example.tour.services.commentServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.CommentDto;
import org.example.tour.entity.Comment;
import org.example.tour.entity.Tour;
import org.example.tour.projection.CommentProjection;
import org.example.tour.repository.CommentRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final TourRepo tourRepo;

    @Override
    public List<Comment> getCommentsByTourId(UUID tourId) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        return commentRepo.getCommentsByTour(tour);
    }

    @Override
    public void deletComment(UUID commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow();
        comment.setTour(null);
        commentRepo.save(comment);
        commentRepo.deleteById(commentId);
    }

    @Override
    public void addComment(CommentDto dto,UUID tourId) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        Comment comment = new Comment();
        comment.setVisible(false);
        comment.setText(dto.getText());
        comment.setLastName(dto.getLastName());
        comment.setFirstName(dto.getFirstName());
        comment.setTour(tour);
        commentRepo.save(comment);
    }

    @Override
    public void changeCommentVisible(UUID commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow();
        comment.setVisible(true);
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public List<Comment> getCommentVisble(Boolean visible) {
        return commentRepo.getCommentsVisible(visible);
    }

}
