package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String path;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
