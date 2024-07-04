package org.example.tour.dto;

import lombok.Data;
import org.example.tour.entity.enums.Language;

import java.util.UUID;

@Data
public class ExcludedDto {
    private String excluded;
    private Language lang;
    private UUID tour_id;
}
