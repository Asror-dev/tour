    package org.example.tour.entity;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

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
        private String title;
        private String description;

        @ManyToOne
        @PrimaryKeyJoinColumn
        @JsonIgnore

        private Tour tour;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tourDay")
        @JsonIgnore

        private List<Image> images;
    }
