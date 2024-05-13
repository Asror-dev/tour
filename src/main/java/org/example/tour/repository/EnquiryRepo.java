package org.example.tour.repository;

import org.example.tour.entity.Enquiry;
import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.example.tour.projection.CommentProjection;
import org.example.tour.projection.EnquiryProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnquiryRepo extends JpaRepository<Enquiry, UUID> {
    List<EnquiryProjection> getEnquirysByTour(Tour tour);

}
