package org.example.tour.repository;

import org.example.tour.entity.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailMessageRepo extends JpaRepository<EmailMessage, UUID> {
    List<EmailMessage> getEmailMessageByEnquiry_Id(UUID id);
}
