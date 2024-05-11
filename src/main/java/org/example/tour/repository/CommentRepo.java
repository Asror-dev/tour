package org.example.tour.repository;

import org.example.tour.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepo extends JpaRepository<Comment, UUID> {

    @Query(value = "select c from comments c where c.tour.id=:tourId")
    List<Comment> getCommentByTourId(@Param("tourId")UUID tourId);
}
