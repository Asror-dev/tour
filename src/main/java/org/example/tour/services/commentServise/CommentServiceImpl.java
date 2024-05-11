package org.example.tour.services.commentServise;

import lombok.RequiredArgsConstructor;
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
    public List<CommentProjection> getCommentsByTourId(UUID tourId) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        return commentRepo.getCommentsByTour(tour);
    }
}
