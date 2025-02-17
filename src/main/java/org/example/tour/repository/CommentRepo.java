package org.example.tour.repository;

import org.example.tour.entity.Comment;
import org.example.tour.entity.Tour;
import org.example.tour.projection.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface CommentRepo extends JpaRepository<Comment, UUID> {



@Query(value = "select * from comments where visible=:visible",nativeQuery = true)
    List<Comment> getCommentsVisible(@Param("visible")Boolean visible);

}
