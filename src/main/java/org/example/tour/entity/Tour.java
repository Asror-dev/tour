package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore

    private List<TourDay> tourDays;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore

    private List<Video> videos;

    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Image> images;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore

    private List<Comment> comments;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore

    private List<Enquiry> enquiries;
}
