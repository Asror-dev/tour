package org.example.tour.repository;

import org.example.tour.entity.Comment;
import org.example.tour.entity.Tour;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.Video;
import org.example.tour.projection.TourDayProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TourDayRepo extends JpaRepository<TourDay, UUID> {
    @Query(value = """
            select ts.id as id, ts.title as title, ts.description as description, i.path as path
                   from tour_days ts join tour t on ts.tour_id = t.id
                join images i on i.tour_day_id = ts.id
            where ts.tour_id = :tourId
            """, nativeQuery = true)
    List<TourDayProjection> getTourDaysByTourId(@Param("tourId") UUID tourId);
    @Query(value = "SELECT * FROM tour_days WHERE tour_id = :tour_id", nativeQuery = true)
    List<TourDay> getTourDayByByTour(@Param("tour_id") UUID tour_id);
}
