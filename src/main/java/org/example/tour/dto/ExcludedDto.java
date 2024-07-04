package org.example.tour.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ExcludedDto {
    private String excluded;
    private UUID tour_id;
}
