package org.example.tour.repository;

import org.example.tour.entity.Image;
import org.example.tour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepo extends JpaRepository<Image, UUID> {
}
