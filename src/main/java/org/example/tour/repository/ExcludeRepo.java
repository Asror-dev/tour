package org.example.tour.repository;

import org.example.tour.entity.Excluded;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExcludeRepo extends JpaRepository<Excluded, UUID> {
}
