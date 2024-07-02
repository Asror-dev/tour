package org.example.tour.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tour.entity.enums.Language;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "timetableAccessibility")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableAccessibility {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean summa;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @PrimaryKeyJoinColumn
    private Tour tour;
    @Enumerated(EnumType.STRING)
    private Language lang;

}
