package org.example.tour.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EnquiryDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String text;
    private UUID tourId;
}
