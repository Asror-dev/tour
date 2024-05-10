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

    @OneToMany(mappedBy = "tour")
    private List<TourDay> tourDays;

    @OneToMany(mappedBy = "tour")
    private List<Video> videos;

    @OneToMany(mappedBy = "tour")
    private List<Image> images;

    @OneToMany(mappedBy = "tour")
    private List<Comment> comments;

    @OneToMany(mappedBy = "tour")
    private List<Enquiry> enquiries;
}
