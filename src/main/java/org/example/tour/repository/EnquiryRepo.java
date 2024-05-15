package org.example.tour.repository;

import org.example.tour.entity.Comment;
import org.example.tour.entity.Enquiry;
import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.example.tour.projection.CommentProjection;
import org.example.tour.projection.EnquiryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnquiryRepo extends JpaRepository<Enquiry, UUID> {
    List<EnquiryProjection> getEnquirysByTour(Tour tour);
    @Query(value = "SELECT * FROM enquiry WHERE tour_id = :tour_id", nativeQuery = true)
    List<Enquiry> getEnquiryByTour(@Param("tour_id") UUID tour_id);
}
