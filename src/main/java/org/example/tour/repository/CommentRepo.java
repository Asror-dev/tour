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


    List<Comment> getCommentsByTour(Tour tour);
//    @Query("select ")
//    List<CommentProjection> findCommentByTourId(UUID tourId);
@Query(value = "SELECT * FROM comments WHERE tour_id = :tour_id", nativeQuery = true)
List<Comment> getCommentByTour(@Param("tour_id") UUID tour_id);

@Query(value = "select * from comments where visible=:visible",nativeQuery = true)
    List<Comment> getCommentsVisible(@Param("visible")Boolean visible);

    @Query(value = "select * from comments where tour_id=:tourId and visible=:visible",nativeQuery = true)
    List<Comment> getCommentsByTourIdAndVisible(@Param("tourId")UUID tourId,@Param("visible")Boolean visible);

    List<Comment> getCommentsByTourIdAndVisibleTrue(UUID tourId);
}
