package org.example.tour.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
public class EnquiryDto {
    private String firstName;
    private String lastName;

    @NotEmpty(message = "Phone cannot be empty")
    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?(\\(?\\d{1,4}\\)?[- ]?)?\\d{1,4}[- ]?\\d{1,4}[- ]?\\d{1,9}$",
            message = "Phone number is not valid"
    )
    private String phone;
    @NotEmpty(message = "Email cannot be empty")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Email is not valid"
    )
    private String email;
    private String text;
    private UUID tourId;
}
