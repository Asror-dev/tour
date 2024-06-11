package org.example.tour.services.enquiryServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.EnquiryDto;
import org.example.tour.entity.EmailMessage;
import org.example.tour.entity.Enquiry;
import org.example.tour.entity.Tour;
import org.example.tour.projection.EnquiryProjection;
import org.example.tour.repository.EnquiryRepo;
import org.example.tour.repository.TourRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {
    private final TourRepo tourRepo;
    private final EnquiryRepo enquiryRepo;
    @Override
    public void addEnquiry(EnquiryDto dto) {

        Tour tour = tourRepo.findById(dto.getTourId()).orElseThrow();
        Enquiry enquiry=new Enquiry();

        enquiry.setEmail(dto.getEmail());
        enquiry.setLastName(dto.getLastName());
        enquiry.setFirstName(dto.getFirstName());
        enquiry.setText(dto.getText());
        enquiry.setPhone(dto.getPhone());
        enquiry.setTour(tour);
        enquiry.setEmails(List.of(new EmailMessage()));
        enquiryRepo.save(enquiry);
    }

    @Override
    public List<EnquiryProjection> getEnquiryByTourId(UUID tourId) {
        Tour tour = tourRepo.findById(tourId).orElseThrow();
        return enquiryRepo.getEnquirysByTour(tour);
    }

    @Override
    public List<Enquiry> getAllEnquiry() {
        return enquiryRepo.findAll();
    }


}
