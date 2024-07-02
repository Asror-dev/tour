package org.example.tour.controller;

import lombok.RequiredArgsConstructor;
import org.example.tour.dto.ContactDto;
import org.example.tour.entity.Contact;
import org.example.tour.services.ContactServise.ContactServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
private final ContactServise contactServise;
    @PostMapping("/post")
    public ResponseEntity<?> postContact(@RequestBody ContactDto dto) {
        try {
          contactServise.addContact(dto);
            return ResponseEntity.ok("post contact");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity<?> getContact(){
        try {
            List<Contact> contacts = contactServise.getContacts();
            return ResponseEntity.ok(contacts);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
