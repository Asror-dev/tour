package org.example.tour.repository;

import org.example.tour.entity.Enquiry;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnquiryRepo extends JpaRepository<Enquiry, UUID> {
}
