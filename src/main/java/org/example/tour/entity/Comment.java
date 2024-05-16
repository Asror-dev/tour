package org.example.tour.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Firstname cannot be empty")
    private String firstName;
    private String lastName;
    private String text;
    private Boolean visible;

    @ManyToOne()
    @PrimaryKeyJoinColumn

    private Tour tour;

}
