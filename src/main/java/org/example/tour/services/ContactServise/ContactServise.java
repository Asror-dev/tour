package org.example.tour.services.ContactServise;

import org.example.tour.dto.ContactDto;
import org.example.tour.entity.Contact;
import org.example.tour.entity.enums.Language;

import java.util.List;

public interface ContactServise {
    void addContact(ContactDto dto, Language language);
    List<Contact> getContacts(Language language);
}
