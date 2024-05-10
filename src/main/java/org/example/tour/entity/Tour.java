package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private Double price;

    @OneToMany
    private List<TourDay> tourDays;

    @OneToMany
    private List<Video> videos;

    @OneToMany
    private List<Image> images;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Enquiry> enquiries;
}
