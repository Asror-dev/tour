package org.example.tour.services.emailService;

import jakarta.mail.MessagingException;
import org.example.tour.entity.EmailMessage;

import java.util.List;
import java.util.UUID;

public interface EmailService {
    void sendSimpleEmail(String subject, String text, UUID enquiryId) throws MessagingException;
    List<EmailMessage> getEmailByEnquiry(UUID id);
}
