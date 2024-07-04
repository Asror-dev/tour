package org.example.tour.repository;

import org.example.tour.entity.Included;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncludedRepo extends JpaRepository<Included, UUID> {
}
