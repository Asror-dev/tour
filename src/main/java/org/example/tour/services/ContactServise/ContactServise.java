package org.example.tour.services.ContactServise;

import org.example.tour.dto.ContactDto;
import org.example.tour.entity.Contact;

import java.util.List;

public interface ContactServise {
    void addContact(ContactDto dto);
    List<Contact> getContacts();
}
