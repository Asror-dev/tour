package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "enquiry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String text;

    @ManyToOne
    @PrimaryKeyJoinColumn

    private Tour tour;
}
