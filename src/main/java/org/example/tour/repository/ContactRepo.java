package org.example.tour.repository;

import org.example.tour.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
}
