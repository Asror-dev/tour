package org.example.tour.repository;

import org.example.tour.entity.Comment;
import org.example.tour.entity.Tour;
import org.example.tour.projection.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {


    List<CommentProjection> getCommentsByTour(Tour tourId);
}
