    package org.example.tour.entity;

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

        @ManyToOne
        @JoinColumn(name = "tour_id")
        private Tour tour;

//        @OneToMany(cascade = CascadeType.ALL)
//        private List<Image> images;
    }
