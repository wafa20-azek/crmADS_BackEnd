package org.example.repository;

import org.example.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface contactRepository extends CrudRepository<Contact, Long> {

}
