package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tour.entity.enums.Language;

import java.util.UUID;

@Entity(name = "contact")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Language lang;
}
