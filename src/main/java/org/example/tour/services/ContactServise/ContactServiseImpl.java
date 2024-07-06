package org.example.tour.services.ContactServise;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.ContactDto;
import org.example.tour.entity.Contact;
import org.example.tour.entity.enums.Language;
import org.example.tour.repository.ContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiseImpl implements ContactServise {
    private final ContactRepo contactRepo;

    @Override
    public void addContact(ContactDto dto, Language language) {
        Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setPhone(dto.getPhone());
        contact.setLang(language);
        contactRepo.save(contact);
    }
    @Override
    public List<Contact> getContacts(Language language) {
        return contactRepo.getContactsByLang(language);
    }
}
