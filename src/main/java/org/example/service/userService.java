package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class userService implements IUserService{
    final userRepository userRepository;
    @Override
    public <S extends User> S save(S user) {
        return userRepository.save(user);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Optional<User> findById(Long idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public boolean existsById(Long idUser) {
        return userRepository.existsById(idUser);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return userRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        userRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends User> users) {
        userRepository.deleteAll(users);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
