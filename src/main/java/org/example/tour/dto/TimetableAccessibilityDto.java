package org.example.tour.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TimetableAccessibilityDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean summa;
    private UUID tourId;
    private String info;
    private Integer price;
    private Integer secondPrice;

}
