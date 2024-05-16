package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String name;
    @NotEmpty
    private String path;

    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Tour tour;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private TourDay tourDay;




}
