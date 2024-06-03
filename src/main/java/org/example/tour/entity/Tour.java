package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.example.tour.entity.enums.Language;

import java.util.List;
import java.util.UUID;

@Entity(name = "tour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String description1;

    private Double price;
    private Integer tourDay;
    private String info;
    @Enumerated(EnumType.STRING)
    private Language lang;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore
    private List<TourDay> tourDays;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonManagedReference
    private List<Video> videos;

    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER)
        @JsonManagedReference
    private List<Image> images;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore
    
    private List<Comment> comments;

    @OneToMany(mappedBy = "tour",fetch =FetchType.EAGER)
    @JsonIgnore

    private List<Enquiry> enquiries;
}
