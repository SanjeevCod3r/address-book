package com.sanjeev.addressbook.repository;

import com.sanjeev.addressbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
