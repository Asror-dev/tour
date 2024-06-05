package org.example.tour.services.enquiryServise;

import org.example.tour.dto.EnquiryDto;
import org.example.tour.entity.Enquiry;
import org.example.tour.projection.EnquiryProjection;

import java.util.List;
import java.util.UUID;

public interface EnquiryService {
    void addEnquiry(EnquiryDto dto);
    List<EnquiryProjection> getEnquiryByTourId(UUID tourId);

    List<Enquiry> getAllEnquiry();

  ;
}
