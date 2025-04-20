package com.sanjeev.addressbook.controller;

import com.sanjeev.addressbook.dto.ContactDTO;
import com.sanjeev.addressbook.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDTO> addContact(@Valid @RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<>(contactService.addContact(contactDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<>(contactService.updateContact(id, contactDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
