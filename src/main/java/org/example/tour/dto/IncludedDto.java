package org.example.tour.dto;

import lombok.Data;
import org.example.tour.entity.enums.Language;

import java.util.UUID;

@Data
public class IncludedDto {
    private String included;
    private Language lang;
    private UUID tour_id;
}
