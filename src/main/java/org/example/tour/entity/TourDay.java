package org.example.tour.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "tour_days")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
