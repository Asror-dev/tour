package org.example.tour.repository;

import org.example.tour.entity.Tour;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TourRepo extends JpaRepository<Tour, UUID> {
    @Query(value = """

select t.id as id, t.description as description, t.price as price, t.title as title, i.path as imagePath, v.path  as videoPath
from tour t join images i on t.id = i.tour_id 
    join video v on t.id = v.tour_id
""",nativeQuery = true)
    List<TourRepo> fds();
}
