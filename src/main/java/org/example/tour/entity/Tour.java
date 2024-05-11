package org.example.tour.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private Double price;
//
//    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
//    private List<TourDay> tourDays;
//
//    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
//    private List<Video> videos;
//
//    @OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "tour")
//    private List<Image> images;
//
//    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
//    private List<Comment> comments;
//
//    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
//    private List<Enquiry> enquiries;
}
