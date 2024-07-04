    package org.example.tour.entity;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.example.tour.entity.enums.Language;

    import java.util.List;
    import java.util.UUID;

    @Entity(name = "tour_days")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class TourDay {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        @NotEmpty
        @NotNull
        private String title;
        @NotEmpty
        @NotNull
        @Column(length = 1000)
        private String description;

        @Enumerated(EnumType.STRING)
        private Language lang;

        @ManyToOne(fetch = FetchType.EAGER)
        @PrimaryKeyJoinColumn
        @JsonBackReference
        private Tour tour;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tourDay")
        @JsonBackReference
        private List<Image> images;
    }
