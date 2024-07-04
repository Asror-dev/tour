package org.example.tour.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "comments")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Firstname cannot be empty")
    @NotEmpty(message = "Firstname cannot be empty")
    private String firstName;
    @NotEmpty(message = "Lastname cannot be empty")
    @NotNull(message = "Lastname cannot be empty")
    private String lastName;
    @NotEmpty(message = "Text cannot be empty")
    @NotNull
    @Column(length = 1000)
    private String text;
    private String title;
    private Boolean visible;
    private int stars;


}
