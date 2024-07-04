package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tour.entity.enums.Language;

import java.util.UUID;

@Entity(name = "included")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Included {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 1000)
    private String included;
    @Enumerated(EnumType.STRING)
    private Language lang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @PrimaryKeyJoinColumn
    private Tour tour;
}
