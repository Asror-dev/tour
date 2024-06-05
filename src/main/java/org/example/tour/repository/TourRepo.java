package org.example.tour.repository;

import org.example.tour.entity.Tour;
import org.example.tour.entity.TourDay;
import org.example.tour.entity.User;
import org.example.tour.entity.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TourRepo extends JpaRepository<Tour, UUID> {




    List<Tour> getToursByLangOrderById(Language lang);

    Tour getTourByIdAndLang(UUID tourId, Language lang);
}
