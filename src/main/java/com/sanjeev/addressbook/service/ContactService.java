package com.sanjeev.addressbook.service;

import com.sanjeev.addressbook.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    ContactDTO addContact(ContactDTO contactDTO);
    List<ContactDTO> getAllContacts();
    ContactDTO getContactById(Long id);
    ContactDTO updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
