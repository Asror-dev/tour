package org.example.tour.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class IncludedDto {
    private String included;
    private UUID tour_id;
}
