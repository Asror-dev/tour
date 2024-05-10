package org.example.tour.repository;

import org.example.tour.entity.User;
import org.example.tour.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepo extends JpaRepository<Video, UUID> {
}
