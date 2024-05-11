package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String path;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "tour_day_id")
    private TourDay tourDay;




}
