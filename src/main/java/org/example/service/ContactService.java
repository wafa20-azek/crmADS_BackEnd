package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Contact;
import org.example.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService implements IContactService{
    final ContactRepository contactRepository;
    @Override
    public <S extends Contact> S save(S contact) {
        return contactRepository.save(contact);
    }

    @Override
    public <S extends Contact> Iterable<S> saveAll(Iterable<S> contacts) {
        return contactRepository.saveAll(contacts);
    }

    @Override
    public Optional<Contact> findById(Long idContact) {
        return contactRepository.findById(idContact);
    }

    @Override
    public boolean existsById(Long idContact) {
        return contactRepository.existsById(idContact);
    }

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Iterable<Contact> findAllById(Iterable<Long> longs) {
        return contactRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return contactRepository.count();
    }

    @Override
    public void deleteById(Long idContact) {
        contactRepository.deleteById(idContact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        contactRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Contact> contacts) {
        contactRepository.deleteAll(contacts);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }
}
