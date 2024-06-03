package org.example.tour.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmailDto {
    private String subject;
    private String text;
    private UUID enquiryId;
}
