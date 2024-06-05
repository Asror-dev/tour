package org.example.tour.services.emailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.tour.entity.EmailMessage;
import org.example.tour.entity.Enquiry;
import org.example.tour.repository.EmailMessageRepo;
import org.example.tour.repository.EnquiryRepo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EnquiryRepo enquiryRepo;
    private final EmailMessageRepo emailMessageRepo;

    public void sendSimpleEmail( String subject, String text, UUID enquiryId) {
    String to = enquiryRepo.findById(enquiryId).orElseThrow().getEmail();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        createMessage(enquiryId,text);

    }

    @Override
    public List<EmailMessage> getEmailByEnquiry(UUID id) {
        return emailMessageRepo.getEmailMessageByEnquiry_Id(id);
    }
//public void sendSimpleEmail(String subject, String htmlBody,UUID enquiryId) throws MessagingException {
//    String to = enquiryRepo.findById(enquiryId).orElseThrow().getEmail();
//
//    MimeMessage mimeMessage = mailSender.createMimeMessage();
//    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//    helper.setText(htmlBody, true);
//    helper.setTo(to);
//    helper.setSubject(subject);
//    helper.setFrom("asrorsattorov06@gmail.com"); // O'z email manzilingizni qo'ying
//    mailSender.send(mimeMessage);
//    createMessage(enquiryId,htmlBody);
//}

    private void createMessage(UUID enquiryId, String text){
        Enquiry enquiry = enquiryRepo.findById(enquiryId).orElseThrow();
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTextMessage(text);
        emailMessage.setEnquiry(enquiry);
        emailMessageRepo.save(emailMessage);
    }
}
