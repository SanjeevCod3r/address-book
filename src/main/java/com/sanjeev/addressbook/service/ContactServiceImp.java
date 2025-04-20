package com.sanjeev.addressbook.service;

import com.sanjeev.addressbook.dto.ContactDTO;
import com.sanjeev.addressbook.entity.Contact;
import com.sanjeev.addressbook.exception.ContactNotFoundException;
import com.sanjeev.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContactServiceImp implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private ContactDTO convertToDTO(Contact contact) {
        return new ContactDTO(
                contact.getName(),
                contact.getEmail(),
                contact.getPhoneNumbers()
        );
    }

    private Contact convertToEntity(ContactDTO dto) {
        return new Contact(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getPhoneNumbers()
        );
    }

    @Override
    public ContactDTO addContact(ContactDTO contactDTO) {
        log.info("Adding contact: {}", contactDTO.getName());
        Contact contact = convertToEntity(contactDTO);
        return convertToDTO(contactRepository.save(contact));
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        log.info("Fetching all contacts");
        return contactRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO getContactById(Long id) {
        log.info("Fetching contact with ID: {}", id);
        return contactRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Override
    public ContactDTO updateContact(Long id, ContactDTO contactDTO) {
        log.info("Updating contact with ID: {}", id);
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));

        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNumbers(contactDTO.getPhoneNumbers());

        return convertToDTO(contactRepository.save(contact));
    }

    @Override
    public void deleteContact(Long id) {
        log.info("Deleting contact with ID: {}", id);
        contactRepository.deleteById(id);

    }
}
