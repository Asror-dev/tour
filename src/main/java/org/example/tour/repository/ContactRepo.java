package org.example.tour.repository;

import org.example.tour.entity.Contact;
import org.example.tour.entity.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepo extends JpaRepository<Contact, UUID> {
    List<Contact> getContactsByLang(Language lang);
}
